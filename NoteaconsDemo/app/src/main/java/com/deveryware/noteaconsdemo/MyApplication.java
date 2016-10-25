/*
 * Copyright (c) 2016. Deveryware Iberia SA. All rights reserved.
 */

package com.deveryware.noteaconsdemo;

import android.app.Application;
import android.util.Log;

import com.deveryware.noteacons.Noteacons;
import com.deveryware.noteacons.notifier.NoteaconsNotifier;


/**
 * Android Main Application.
 */
public class MyApplication extends Application implements NoteaconsNotifier {
    private static final String TAG = "MyApplication";

    @Override
    public void onCreate() {
        super.onCreate();
        //Here you must initialize the Noteacons SDK.
        Noteacons.initSDK(this);
        //Call setNoteaconNotifier() to be notified when the SDK is ready.
        Noteacons.setNoteaconNotifier(this);
        //Call the others setters if you want to customize the behaviour of the SDK.
        Noteacons.setBeaconNotifier(new MyBeaconNotifier());
        Noteacons.setCampaignNotifier(new MyCampaignNotifier());
        Noteacons.setActionNotifier(new MyActionNotifier(getApplicationContext()));
        Noteacons.setGeofenceNotifier(new MyGeofenceNotifier());
    }

    @Override
    public void onNoteaconsReady() {
        //Here is the best place to obtain the Noteacons device identifier.
        Log.d(TAG, "Ready, device id: " + Noteacons.getDeviceId());
    }
}
