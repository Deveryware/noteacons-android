/*
 * Copyright (c) 2016. Deveryware Iberia SA. All rights reserved.
 */

package com.deveryware.noteaconsdemo;

import android.util.Log;

import com.deveryware.noteacons.beacon.NoteaconsBeacon;
import com.deveryware.noteacons.notifier.BeaconNotifier;

/**
 * Implementation of the BeaconNotifier.
 */
public class MyBeaconNotifier implements BeaconNotifier {

    private static final String TAG = "MyBeaconNotifier";

    @Override
    public void onEnterBeacon(NoteaconsBeacon beacon) {
        Log.d(TAG, "onEnterBeacon: "+beacon.toString());

    }

    @Override
    public void onExitBeacon(NoteaconsBeacon beacon) {
        Log.d(TAG, "onExitBeacon: "+beacon.toString());
    }
}
