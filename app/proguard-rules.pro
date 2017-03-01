# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in C:\Users\yeonsulee\AppData\Local\Android\Sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

###### Retrofit2
-dontnote retrofit2.Platform
-dontwarn retrofit2.Platform$Java8
-keepattributes Signature
-keepattributes Exceptions

###### converter-gson
-keep class com.google.gson.** { *; }
-keep class com.google.inject.** { *; }

###### Glide
-keep public class * implements com.bumptech.glide.module.GlideModule
-keep public enum com.bumptech.glide.load.resource.bitmap.ImageHeaderParser$** {
  **[] $VALUES;
  public *;
}

###### OKHttp
-keep class okhttp3.**
-keep interface okhttp3.**
-dontwarn okhttp3.**
-dontwarn okio.**
-keep class okio.** { *; }

###### v7
-keep class android.support.v7.** { *; }
-keep interface android.support.v7.** { *; }

###### design
-dontwarn android.support.design.**
-keep class android.support.design.** { *; }
-keep interface android.support.design.** { *; }
-keep public class android.support.design.R$* { *; }

###### cardview
-keep class android.support.v7.widget.RoundRectDrawable { *; }

###### recyclerview
-keep public class * extends android.support.v7.widget.RecyclerView$LayoutManager {
    public <init>(...);
}

###### duplicate
-dontnote android.net.http.**
-dontnote org.apache.commons.codec.**
-dontnote org.apache.http.**

###### dynamically
-dontwarn sun.misc.Unsafe
-dontwarn com.android.org.conscrypt.SSLParametersImpl
-dontwarn org.apache.harmony.xnet.provider.jsse.SSLParametersImpl
-dontwarn dalvik.system.CloseGuard
-dontwarn sun.security.ssl.SSLContextImpl
-keep class com.google.gson.internal.UnsafeAllocator { java.lang.reflect.Field theUnsafe; }
