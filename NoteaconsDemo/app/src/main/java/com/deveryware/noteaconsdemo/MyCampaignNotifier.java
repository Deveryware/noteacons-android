/*
 * Copyright (c) 2016. Deveryware Iberia SA. All rights reserved.
 */

package com.deveryware.noteaconsdemo;

import android.util.Log;
import android.util.SparseArray;

import com.deveryware.noteacons.notifier.CampaignNotifier;
import com.deveryware.noteacons.campaign.NoteaconsContext;

import java.util.Date;

/**
 * Implementation of the CampaignNotifier.
 * We use the willLaunchCampaign callback to avoid the same campaign launched
 * more than once in 2 minutes.
 */
public class MyCampaignNotifier implements CampaignNotifier {

    private static final String TAG = "MyCampaignNotifier";
    private final static long CAMPAIGN_INTERVAL_IN_MILLISECONDS = 1000L * 60 * 2; //2 minutes

    SparseArray<Long> executedCampaigns = new SparseArray<>();

    @Override
    public boolean willLaunchCampaign(NoteaconsContext context) {
        Log.d(TAG, "willLaunchCampaign: "+ context.getCampaignId());
        long lastTimeExecuted = executedCampaigns.get(context.getCampaignId(), 0L);
        long now = new Date().getTime();
        return now - lastTimeExecuted >= CAMPAIGN_INTERVAL_IN_MILLISECONDS;
    }

    @Override
    public void didLaunchCampaign(NoteaconsContext context) {
        Log.d(TAG, "didLaunchCampaign");
        executedCampaigns.put(context.getCampaignId(), new Date().getTime());
    }
}
