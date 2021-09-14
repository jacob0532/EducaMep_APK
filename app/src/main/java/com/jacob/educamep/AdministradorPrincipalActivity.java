package com.jacob.educamep;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class AdministradorPrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.administradorprincipal);
        Button btnCursos = findViewById(R.id.btnCursos);
        Button btnDocentes = findViewById(R.id.btnDocentes);
        Button btnEstudiantes = findViewById(R.id.btnEstudiantes);
        Button btnAsignacion = findViewById(R.id.btnAsignacion);
        Button btnSalir = findViewById(R.id.btnSalir);
    }
}