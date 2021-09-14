package com.jacob.educamep;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Spinner;

public class DocentePrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.docenteprincipal);
        Spinner comboBoxCursos = findViewById(R.id.sCursos);
        Button btnPublicarNoticia = findViewById(R.id.btnNoticia);
        Button btnAsignarTarea = findViewById(R.id.btnTarea);
        Button btnListaEstudiantes = findViewById(R.id.btnLista);
        Button btnChatCurso = findViewById(R.id.btnChat);
        Button btnSalir = findViewById(R.id.btnSalir);
    }
}