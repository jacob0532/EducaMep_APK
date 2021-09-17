package com.jacob.educamep;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Spinner;

import com.jacob.educamep.clasesLogicas.Docente;
import com.jacob.educamep.clasesLogicas.Estudiante;

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
        Docente usuario = (Docente) getIntent().getSerializableExtra("usuario");
        Log.d("EJEMPLO",usuario.nombre);
    }
}