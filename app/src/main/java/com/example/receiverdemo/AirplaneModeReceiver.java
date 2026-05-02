package com.example.receiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AirplaneModeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context drk_context, Intent drk_intent) {
        if (Intent.ACTION_AIRPLANE_MODE_CHANGED.equals(drk_intent.getAction())) {
            boolean drk_isAirplaneOn = drk_intent.getBooleanExtra("state", false);
            String drk_message = drk_isAirplaneOn 
                ? "Mode Avion ACTIVÉ - Plus de connexion !" 
                : "Mode Avion DÉSACTIVÉ - Connexions rétablies";
            Toast.makeText(drk_context, drk_message, Toast.LENGTH_LONG).show();
        }
    }
}
