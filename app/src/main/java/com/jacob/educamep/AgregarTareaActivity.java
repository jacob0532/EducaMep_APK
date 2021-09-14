package com.jacob.educamep;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AgregarTareaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agregartarea);
        TextView lblNombreCurso = findViewById(R.id.tvCursoActual);
        TextView lblIdTarea = findViewById(R.id.tvIDTarea2);
        EditText txtTitulo = findViewById(R.id.tbTitulo);
        EditText txtFecha = findViewById(R.id.tbTitulo3);
        EditText txtDescripcion = findViewById(R.id.taDescripcion);
        Button btnCalendario = findViewById(R.id.btnCalendar);
        Button btnPublicar = findViewById(R.id.btnPublicar);
        Button btnAtras = findViewById(R.id.btnAtras);
    }
}