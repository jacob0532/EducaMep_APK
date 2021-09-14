package com.jacob.educamep;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;

public class ListaEstudiantesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listaestudiantes);
        final TextView lblCurso = findViewById(R.id.tvCursoActual);
        final TableLayout tblEstudiante = findViewById(R.id.tablaEstudiantes);
        final Button btnAtras = findViewById(R.id.btnAtras);
    }
}