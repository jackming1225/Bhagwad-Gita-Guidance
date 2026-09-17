# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.

# Preserve line number information for readable deobfuscated stack traces in Play Console
-keepattributes SourceFile,LineNumberTable
-renamesourcefileattribute SourceFile

# Preserve generic type signatures and annotations for reflection/serialization
-keepattributes *Annotation*,Signature,InnerClasses,EnclosingMethod

# Keep native methods for JNI libs
-keepclasseswithmembernames class * {
    native <methods>;
}

# Room Database & Entities
-keep class androidx.room.** { *; }
-keep class * extends androidx.room.RoomDatabase
-keep @androidx.room.Entity class * { *; }
-keep @androidx.room.Dao interface * { *; }
-dontwarn androidx.room.paging.**

# Data Models & Serialization
-keep class com.example.data.model.** { *; }
-keep class com.example.data.local.** { *; }
-keepclassmembers class * {
    @kotlinx.serialization.Serializable <fields>;
}

# OkHttp / Retrofit (if used)
-dontwarn okhttp3.**
-dontwarn okio.**
-keepnames class okhttp3.internal.publicsuffix.PublicSuffixDatabase

# Coroutines
-dontwarn kotlinx.coroutines.**

