package com.jacob.educamep;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class PerfilEstudianteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.perfilestudiante);
        final TextView lblNombreCurso = findViewById(R.id.tvCursoActual);
        final TextView lblNombreEstudiante= findViewById(R.id.tvNombre2);
        final TextView lblPrimerApellido= findViewById(R.id.tvPrimerApellido2);
        final TextView lblSegundoApellido= findViewById(R.id.tvSegundoApellido2);
        final TextView lblCedula = findViewById(R.id.tvCarnet2);
        final TextView lblGradoEscolar = findViewById(R.id.tvGrado2);
        final TextView lblCorreo = findViewById(R.id.tvCorreo2);
        final Button btnAtras = findViewById(R.id.btnAtras);
    }
}