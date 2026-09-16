# Instructions for Generating Release Android App Bundle (.aab)

This document provides step-by-step instructions to create the signed `.aab` file ready for upload to Google Play Console.

---

## 🔑 Step 1: Create an Upload Keystore (One-time setup)

To sign releases for the Google Play Store, create an upload key:

### Using Android Studio GUI:
1. Open the project in Android Studio.
2. In the top menu, go to **Build > Generate Signed Bundle / APK...**
3. Select **Android App Bundle** and click **Next**.
4. Under *Key store path*, click **Create new...**:
   - Choose a safe directory on your computer (e.g., `~/keystores/gita-wisdom-upload.jks`).
   - Enter a secure password for the keystore and key.
   - Set Alias to: `upload`
   - Validity: at least 25 or 50 years.
   - Enter your name/organization in the certificate fields.
5. Click **OK**. Keep this keystore file and its password backed up safely!

### Or using Terminal / Keytool:
```bash
keytool -genkey -v -keystore gita-upload-key.jks -keyalg RSA -keysize 2048 -validity 10000 -alias upload
```

---

## 📦 Step 2: Build the Signed Release App Bundle (.aab)

### Option A: Using Android Studio (Recommended & Simplest)
1. In Android Studio, go to **Build > Generate Signed Bundle / APK...**
2. Choose **Android App Bundle** and click **Next**.
3. Point to your created `gita-upload-key.jks`, enter the passwords, and key alias `upload`.
4. Select the **release** build variant and click **Finish**.
5. Android Studio will generate the bundle at:
   ```
   app/release/app-release.aab
   ```

### Option B: Using Command Line with Environment Variables
Set the environment variables and run Gradle:
```bash
export STORE_FILE="/path/to/your/gita-upload-key.jks"
export STORE_PASSWORD="your_keystore_password"
export KEY_PASSWORD="your_key_password"

./gradlew :app:bundleRelease
```
The output file will be generated in:
```
app/build/outputs/bundle/release/app-release.aab
```

---

## 🚀 Step 3: Upload to Google Play Console

1. Log in to [Google Play Console](https://play.google.com/console).
2. Click **Create app**:
   - **App name**: `Gita Wisdom: Daily Reflection`
   - **Default language**: English (United States) or English (India)
   - **App or game**: App
   - **Free or paid**: Free
3. Navigate to **Testing > Closed testing** (or Internal testing).
4. Click **Create new release**:
   - Upload your `app-release.aab`.
   - Release name: e.g. `1.0.0 (1)`
   - Release notes:
     ```text
     Initial release of Gita Wisdom:
     • 12 Indian languages support
     • Daily reflections, contemplative journaling, and streak tracking
     • Mindful AI spiritual companion with offline-first wisdom fallback
     • High-fidelity Sanskrit shloka audio recitation
     ```
5. Fill out the **Store presence > Main store listing** and **Policy > App content** using the details in `PLAY_STORE_METADATA.md` and `PRIVACY_POLICY.md`.
6. Submit for review!
