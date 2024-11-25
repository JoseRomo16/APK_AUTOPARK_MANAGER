package com.example.autoparkmanager.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.autoparkmanager.R;
import com.example.autoparkmanager.utils.HttpRequestHelper;

public class VehicleEntryActivity extends AppCompatActivity {

    private EditText editTextPlate, editTextModel, editTextColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_entry);

        editTextPlate = findViewById(R.id.editTextPlate);
        editTextModel = findViewById(R.id.editTextModel);
        editTextColor = findViewById(R.id.editTextColor);
    }

    public void registerVehicle(View view) {
        String plate = editTextPlate.getText().toString();
        String model = editTextModel.getText().toString();
        String color = editTextColor.getText().toString();

        if (plate.isEmpty() || model.isEmpty() || color.isEmpty()) {
            Toast.makeText(this, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show();
            return;
        }

        String jsonBody = "{ \"plate\": \"" + plate + "\", \"model\": \"" + model + "\", \"color\": \"" + color + "\" }";
        String response = HttpRequestHelper.makePostRequest("http://localhost/phpmyadmin/index.php?route=/database/structure&db=parking_manager", jsonBody);

        if (response != null) {
            Toast.makeText(this, "Vehículo registrado exitosamente", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Error al registrar el vehículo", Toast.LENGTH_SHORT).show();
        }
    }
}

