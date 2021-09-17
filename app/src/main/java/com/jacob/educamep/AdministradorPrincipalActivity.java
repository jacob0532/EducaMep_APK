package com.jacob.educamep;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.jacob.educamep.clasesLogicas.Administrador;
import com.jacob.educamep.clasesLogicas.BDEducaMep;
import com.jacob.educamep.clasesLogicas.Estudiante;

import java.util.ArrayList;

public class AdministradorPrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.administradorprincipal);
        final Button btnCursos = findViewById(R.id.btnCursos);
        final Button btnDocentes = findViewById(R.id.btnDocentes);
        final Button btnEstudiantes = findViewById(R.id.btnEstudiantes);
        final Button btnAsignacion = findViewById(R.id.btnAsignacion);
        final Button btnSalir = findViewById(R.id.btnSalir);
        Administrador usuario = (Administrador) getIntent().getSerializableExtra("usuario");
    }
}