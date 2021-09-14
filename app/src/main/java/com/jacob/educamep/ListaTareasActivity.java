package com.jacob.educamep;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;

public class ListaTareasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listatareas);
        final TextView lblCurso = findViewById(R.id.tvCursoActual);
        final TableLayout tblTareas = findViewById(R.id.tablaTareas);
        final Button btnAtras = findViewById(R.id.btnAtras);
    }
}