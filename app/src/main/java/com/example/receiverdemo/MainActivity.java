package com.example.receiverdemo;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private AirplaneModeReceiver drk_airplaneReceiver;
    private boolean drk_isReceiverRegistered = false;
    private Button drk_btnToggleAirplane, drk_btnSendCustom;
    private TextView drk_tvStatus;

    @Override
    protected void onCreate(Bundle drk_savedInstanceState) {
        super.onCreate(drk_savedInstanceState);
        setContentView(R.layout.activity_main);

        drk_airplaneReceiver = new AirplaneModeReceiver();
        drk_tvStatus = findViewById(R.id.drk_tvStatus);
        drk_btnToggleAirplane = findViewById(R.id.drk_btnToggleAirplane);
        drk_btnSendCustom = findViewById(R.id.drk_btnSendCustom);

        drk_btnToggleAirplane.setOnClickListener(drk_v -> drk_toggleAirplaneReceiver());
        drk_btnSendCustom.setOnClickListener(drk_v -> drk_sendCustomBroadcast());
    }

    private void drk_toggleAirplaneReceiver() {
        if (!drk_isReceiverRegistered) {
            IntentFilter drk_filter = new IntentFilter();
            drk_filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
            
            registerReceiver(drk_airplaneReceiver, drk_filter);
            drk_isReceiverRegistered = true;
            drk_tvStatus.setText("Receiver Mode Avion : ACTIVÉ (dynamique)");
            drk_btnToggleAirplane.setText("Désactiver Receiver Avion");
        } else {
            unregisterReceiver(drk_airplaneReceiver);
            drk_isReceiverRegistered = false;
            drk_tvStatus.setText("Receiver Mode Avion : DÉSACTIVÉ");
            drk_btnToggleAirplane.setText("Activer Receiver Avion");
        }
    }

    private void drk_sendCustomBroadcast() {
        Intent drk_intent = new Intent("com.example.receiverdemo.CUSTOM_EVENT");
        drk_intent.putExtra("message", "Bonjour depuis le custom broadcast !");
        sendBroadcast(drk_intent);
        
        Toast.makeText(this, "Custom Broadcast envoyé !", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        if (drk_isReceiverRegistered) {
            unregisterReceiver(drk_airplaneReceiver);
        }
        super.onDestroy();
    }
}
