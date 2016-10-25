/*
 * Copyright (c) 2016. Deveryware Iberia SA. All rights reserved.
 */

package com.deveryware.noteaconsdemo;


import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.deveryware.noteacons.action.NoteaconsAction;
import com.deveryware.noteacons.notifier.ActionNotifier;

/**
 * Implementation of the ActionNotifier.
 */
public class MyActionNotifier implements ActionNotifier {

    private static final String TAG = "MyActionNotifier";
    private Context context;
    private NoteaconsAction action;

    public MyActionNotifier(Context context) {
        this.context = context;
    }


    @Override
    public boolean onExecuteActionCustomCallback(NoteaconsAction action, String functionName, String params) {
        Log.w(TAG, "onExecuteActionCustomCallback: Text" + functionName+ "ActionID: "+action.getActionId());
        this.action = action;
        Intent intent = new Intent(context, CustomActionActivity.class);
        intent.putExtra("Offer", functionName);
        intent.putExtra("Action", action);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
        return true;
    }

    @Override
    public boolean onExecuteActionMessage(NoteaconsAction action, String title, String message) {
        return false;
    }
}
