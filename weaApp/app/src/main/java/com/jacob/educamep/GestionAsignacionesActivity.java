package com.jacob.educamep;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class GestionAsignacionesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gestionasignaciones);
        final Button btnAsignarDocente = findViewById(R.id.btnAgregar);
        final Button btnAsignarEstudiante = findViewById(R.id.btnEliminar);
        final Button btnAtras = findViewById(R.id.btnAtras);
    }
}