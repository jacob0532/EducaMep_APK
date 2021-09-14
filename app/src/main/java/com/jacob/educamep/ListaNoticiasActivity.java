package com.jacob.educamep;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;

public class ListaNoticiasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listanoticias);
        final TextView lblCurso = findViewById(R.id.tvCursoActual);
        final TableLayout tblNoticias = findViewById(R.id.tablaNoticias);
        final Button btnAtras = findViewById(R.id.btnAtras);
    }
}