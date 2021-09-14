package com.jacob.educamep;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class GestionCursosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gestioncursos);
        final Button btnAgregar = findViewById(R.id.btnAgregar);
        final Button btnEliminar = findViewById(R.id.btnEliminar);
        final Button btnModificar = findViewById(R.id.btnModificar);
        final Button btnAtras = findViewById(R.id.btnAtras);
    }
}