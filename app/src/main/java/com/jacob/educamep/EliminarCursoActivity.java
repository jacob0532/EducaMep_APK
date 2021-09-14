package com.jacob.educamep;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TextView;

public class EliminarCursoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eliminarcurso);
        final Spinner comboBoxCurso = findViewById(R.id.sCursos);
        final TextView lblNombre = findViewById(R.id.tvNombreCurso);
        final TextView lblGrado = findViewById(R.id.tvGradoDelCurso);
        final TableLayout tblHorarios = findViewById(R.id.tableHorarios);
        final Button btnEliminar = findViewById(R.id.btnEliminar);
        final Button btnAtras = findViewById(R.id.btnAtras);
    }
}