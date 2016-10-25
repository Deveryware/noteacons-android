#Noteacons SDK

[![Release](https://jitpack.io/v/org.bitbucket.deverywareiberia/sdk-android.svg)](https://jitpack.io/#org.bitbucket.deverywareiberia/sdk-android)

Welcome to Noteacons! 

Simple, effective and potent proximity campaigns. 

If you want to edit your campaigns, go to our [dashboard](http://panel.noteacons.com/) and use our [3 simple steps to launch guide](http://www.noteacons.com/support/) to get started.

## Get the Demo App

There's a demo app in this repository, but you can also check out or live demo: [Noteacons Beacon Simulator](https://play.google.com/store/apps/details?id=com.noticoiberia.noteaconsapp)

##Installation

Follow these steps to integrate the Noteacons SDK within an existing project:

Add the JitPack repository in your root build.gradle at the end of repositories:

```
allprojects {
    repositories {
        maven { url "https://jitpack.io" }
    }
}
```

Add the dependecy in your app build.gradle:

```
  dependencies {
      compile 'org.bitbucket.deverywareiberia:sdk-android:v1.2.0'
  }
```

This version works with:

* **Google Play Services 9.8.0** 
* **[Android Beacon Library 2.9.1](http://altbeacon.github.io/android-beacon-library/)**
* **Android Support Library v4 25.0.0**

##Integration

###Manifest

Add your keys in the Manifest.xml file:

```
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.deveryware.noteaconsdemo">

    <application>
        <meta-data android:name="com.deveryware.noteacons.API_KEY" android:value="YOUR_API_KEY"/>
        <meta-data android:name="com.deveryware.noteacons.API_SECRET" android:value="YOUR_API_SECRET"/>
    </application>

</manifest>
```

###Application

In your Application class, call the `initSDK` function: 

```
public class MyApplication extends Application {
    private static final String TAG = "MyApplication";

    @Override
    public void onCreate() {
        super.onCreate();
        Noteacons.initSDK(this);
    }
}
```

Don't forget to add the application name in the manifest.xml file:

```
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.deveryware.noteaconsdemo">
    <application
        android:name="com.deveryware.noteaconsdemo.MyApplication"
    </application>
</manifest>
```

###Notification Icon

You need to specify an icon for the Noteacons SDK notifications. This icon must be in the mipmap folder or in the drawable folder and must be called `noteacons_icon`. If this icon doesn't exist, the SDK won't send notifications.

###Permissions

Beginning in Android 6.0 (API level 23), users grant permissions to apps while the app is running, not when they install the app. [More info] (http://developer.android.com/training/permissions/requesting.html). The Noteacon library requires the `ACCESS_FINE_LOCATION` permission. This permission is in the [dangerous permissions list] (http://developer.android.com/guide/topics/security/permissions.html#normal-dangerous) and you will need to request the permission at runtime:

```
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final int PERMISSION_REQUEST_FINE_LOCATION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //...
        askForPermissions();
        //...
    }

    private void askForPermissions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (this.checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSION_REQUEST_FINE_LOCATION);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_REQUEST_FINE_LOCATION: {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.d(TAG, "Fine location permission granted");
                    Noteacons.fineLocationPermissionGranted();
                } else {
                    Log.w(TAG, "Fine location permission not granted");
                }
            }
        }
    }
}
```

Note that, after the permission has been granted, you must call to the `Noteacons.fineLocationPermissionGranted()` method. [Here] (http://developer.android.com/training/permissions/best-practices.html) you have more info about permissions best practices.

## Customization

To learn more about Noteacons check the [customization docs](http://noteacons-docs.readthedocs.io/en/latest/android/customization/).













