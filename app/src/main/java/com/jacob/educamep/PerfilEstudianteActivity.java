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
        final TextView lblCedula;
        final TextView lblNombreEstudiante;
        final TextView lblPrimerApellido;
        final TextView lblSegundoApellido;
        final TextView lblCorreo;
        final TextView lblGradoEscolar;
        final Button btnAtras = findViewById(R.id.btnAtras);
    }
}