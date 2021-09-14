package com.jacob.educamep;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Spinner;

public class EstudiantePrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.estudianteprincipal);
        final Spinner comboBoxCursos = findViewById(R.id.sCursos);
        final Button btnProfesorEncargado = findViewById(R.id.btnProfesor);
        final Button btnNoticia = findViewById(R.id.btnNoticia);
        final Button btnTarea = findViewById(R.id.btnTarea);
        final Button btnChat = findViewById(R.id.btnChat);
        final Button btnSalir = findViewById(R.id.btnSalir);
    }
}