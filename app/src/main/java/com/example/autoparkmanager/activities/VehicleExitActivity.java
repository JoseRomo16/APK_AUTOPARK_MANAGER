package com.example.autoparkmanager.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.autoparkmanager.R;
import com.example.autoparkmanager.utils.HttpRequestHelper;

public class VehicleExitActivity extends AppCompatActivity {

    private EditText editTextPlate;
    private TextView textViewDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_exit);

        editTextPlate = findViewById(R.id.editTextPlate);
        textViewDetails = findViewById(R.id.textViewDetails);
    }

    public void processVehicleExit(View view) {
        String plate = editTextPlate.getText().toString();

        if (plate.isEmpty()) {
            Toast.makeText(this, "Por favor, ingrese la placa del vehículo", Toast.LENGTH_SHORT).show();
            return;
        }

        // Realizar la solicitud HTTP para procesar la salida
        String response = HttpRequestHelper.makePostRequest(
                "http://localhost/phpmyadmin/index.php?route=/database/structure&db=parking_manager",
                "{ \"exitPlateNumber\": \"" + plate + "\" }"
        );

        if (response != null) {
            // Mostrar los detalles en la pantalla
            textViewDetails.setText("Detalles de salida:\n" + response);
            Toast.makeText(this, "Salida procesada con éxito", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Error al procesar la salida del vehículo", Toast.LENGTH_SHORT).show();
        }
    }
}

