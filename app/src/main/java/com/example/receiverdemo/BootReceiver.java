package com.example.receiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BootReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context drk_context, Intent drk_intent) {
        if (Intent.ACTION_BOOT_COMPLETED.equals(drk_intent.getAction())) {
            Toast.makeText(drk_context, "Téléphone démarré - Receiver statique activé !", Toast.LENGTH_LONG).show();
        }
    }
}
