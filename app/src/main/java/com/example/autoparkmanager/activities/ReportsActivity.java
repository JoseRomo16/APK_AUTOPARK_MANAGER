package com.example.autoparkmanager.activities;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.autoparkmanager.R;
import com.example.autoparkmanager.utils.BarChartView;

public class ReportsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reports);

        LinearLayout chartContainer = findViewById(R.id.chartContainer);

        // Datos de ejemplo para el gráfico
        String[] labels = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes"};
        int[] data = {50, 75, 60, 90, 100};

        try {
            // Agregar el gráfico al contenedor
            BarChartView barChartView = new BarChartView(this, labels, data);
            chartContainer.addView(barChartView);
        } catch (Exception e) {
            Toast.makeText(this, "Error al cargar el gráfico: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}
