package com.jacob.educamep;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AgregarNoticiaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agregarnoticia);
        TextView lblNombreCurso = findViewById(R.id.tvCursoActual);
        EditText txtTitulo = findViewById(R.id.tbTitulo);
        EditText txtDescripcion = findViewById(R.id.taDescripcion);
        Button btnPublicar = findViewById(R.id.btnPublicar);
        Button btnAtras = findViewById(R.id.btnAtras);
    }
}