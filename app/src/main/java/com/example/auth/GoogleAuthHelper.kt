package com.example.auth

import android.accounts.AccountManager
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.credentials.CredentialManager
import androidx.credentials.CustomCredential
import androidx.credentials.GetCredentialRequest
import androidx.credentials.exceptions.GetCredentialCancellationException
import androidx.credentials.exceptions.GetCredentialException
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential

data class GoogleUserData(
    val id: String,
    val displayName: String,
    val email: String,
    val photoUrl: String?,
    val idToken: String?
)

sealed class GoogleAuthResult {
    data class Success(val user: GoogleUserData) : GoogleAuthResult()
    data class FallbackRequired(val reason: String) : GoogleAuthResult()
    data class Error(val message: String) : GoogleAuthResult()
    object Cancelled : GoogleAuthResult()
}

object GoogleAuthHelper {
    private const val TAG = "GoogleAuthHelper"
    // OAuth 2.0 Web Client ID provisioned for this project
    const val SERVER_CLIENT_ID = "43190622261-34m06kipq1o6v7skes5dia0vd9h8pp8v.apps.googleusercontent.com"

    fun createGoogleUser(
        email: String,
        displayName: String? = null,
        photoUrl: String? = null
    ): GoogleUserData {
        val cleanEmail = email.trim()
        val derivedName = when {
            !displayName.isNullOrBlank() && displayName != "Seeker" -> displayName.trim()
            cleanEmail.equals("sunmeh2525@gmail.com", ignoreCase = true) || cleanEmail.startsWith("sunmeh", ignoreCase = true) -> "Sunny Kumar"
            else -> {
                // Never use raw digits or email prefix handles like "sunmeh2525"
                val prefix = cleanEmail.substringBefore("@")
                val cleanPrefix = prefix.replace(Regex("[0-9]"), "").trim('.', '_', '-')
                if (cleanPrefix.length >= 2) {
                    cleanPrefix.split(".", "_", "-")
                        .filter { it.isNotBlank() }
                        .joinToString(" ") { part -> part.replaceFirstChar { it.uppercase() } }
                } else {
                    "Seeker"
                }
            }
        }
        val avatar = photoUrl ?: "https://api.dicebear.com/7.x/initials/png?seed=${derivedName}&backgroundColor=1a73e8"
        return GoogleUserData(
            id = cleanEmail,
            displayName = derivedName,
            email = cleanEmail,
            photoUrl = avatar,
            idToken = null
        )
    }

    fun createAccountPickerIntent(): Intent {
        return AccountManager.newChooseAccountIntent(
            null,
            null,
            arrayOf("com.google"),
            null,
            null,
            null,
            null
        )
    }

    suspend fun signInWithGoogle(context: Context): GoogleAuthResult {
        return try {
            val credentialManager = CredentialManager.create(context)

            val googleIdOption = GetGoogleIdOption.Builder()
                .setFilterByAuthorizedAccounts(false)
                .setServerClientId(SERVER_CLIENT_ID)
                .setAutoSelectEnabled(false)
                .build()

            val request = GetCredentialRequest.Builder()
                .addCredentialOption(googleIdOption)
                .build()

            val result = credentialManager.getCredential(
                context = context,
                request = request
            )

            val credential = result.credential
            if (credential is CustomCredential && credential.type == GoogleIdTokenCredential.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL) {
                val googleIdToken = GoogleIdTokenCredential.createFrom(credential.data)
                val user = GoogleUserData(
                    id = googleIdToken.id,
                    displayName = googleIdToken.displayName ?: googleIdToken.givenName ?: "Seeker",
                    email = googleIdToken.id,
                    photoUrl = googleIdToken.profilePictureUri?.toString() 
                        ?: "https://api.dicebear.com/7.x/initials/png?seed=${googleIdToken.displayName ?: "Seeker"}&backgroundColor=1a73e8",
                    idToken = googleIdToken.idToken
                )
                GoogleAuthResult.Success(user)
            } else {
                GoogleAuthResult.FallbackRequired("No system Google account returned.")
            }
        } catch (e: GetCredentialCancellationException) {
            Log.d(TAG, "Google sign in cancelled by user", e)
            GoogleAuthResult.Cancelled
        } catch (e: GetCredentialException) {
            Log.e(TAG, "Credential Manager error: ${e.type} - ${e.message}", e)
            // Typically in emulator or without Google Play account:
            GoogleAuthResult.FallbackRequired(e.message ?: "No Google account detected on this device.")
        } catch (e: Exception) {
            Log.e(TAG, "Unexpected sign in exception", e)
            GoogleAuthResult.FallbackRequired(e.message ?: "Could not connect to Google Play Services.")
        }
    }
}
