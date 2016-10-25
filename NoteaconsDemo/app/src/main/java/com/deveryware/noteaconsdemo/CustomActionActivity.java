/*
 * Copyright (c) 2016. Deveryware Iberia SA. All rights reserved.
 */

package com.deveryware.noteaconsdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.deveryware.noteacons.action.NoteaconsAction;

public class CustomActionActivity extends AppCompatActivity {

    private static final String TAG = "CustomActionActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_action);
    }

    @Override
    protected void onStop() {
        super.onStop();
        NoteaconsAction action = (NoteaconsAction)getIntent().getSerializableExtra("Action");
        Log.w(TAG, "onStop--> Action ID: "+action.getActionId());
        action.finish(action.getActionId(), getApplicationContext());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.w(TAG, "onDestroy");
    }
}
