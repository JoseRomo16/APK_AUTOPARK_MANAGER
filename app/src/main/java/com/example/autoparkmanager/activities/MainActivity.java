package com.example.autoparkmanager.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.example.autoparkmanager.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void navigateToVehicleEntry(View view) {
        Intent intent = new Intent(this, VehicleEntryActivity.class);
        startActivity(intent);
    }

    public void navigateToVehicleExit(View view) {
        Intent intent = new Intent(this, VehicleExitActivity.class);
        startActivity(intent);
    }

    public void navigateToReports(View view) {
        Intent intent = new Intent(this, ReportsActivity.class);
        startActivity(intent);
    }
}

