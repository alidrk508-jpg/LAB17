package com.example.receiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class CustomEventReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context drk_context, Intent drk_intent) {
        if ("com.example.receiverdemo.CUSTOM_EVENT".equals(drk_intent.getAction())) {
            String drk_message = drk_intent.getStringExtra("message");
            Toast.makeText(drk_context, "Custom reçu : " + drk_message, Toast.LENGTH_LONG).show();
        }
    }
}
