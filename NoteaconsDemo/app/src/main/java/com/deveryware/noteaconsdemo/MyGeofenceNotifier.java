package com.deveryware.noteaconsdemo;

import android.util.Log;

import com.deveryware.noteacons.location.NoteaconsGeofence;
import com.deveryware.noteacons.notifier.GeofenceNotifier;


public class MyGeofenceNotifier implements GeofenceNotifier {

    private static final String TAG = "MyGeofenceNotifier";

    @Override
    public void onEnterGeofence(NoteaconsGeofence geofence) {
        Log.d(TAG, "onEnterGeofence: " + geofence.toString());
    }

    @Override
    public void onExitGeofence(NoteaconsGeofence geofence) {
        Log.d(TAG, "onExitGeofence: " + geofence.toString());
    }
}
