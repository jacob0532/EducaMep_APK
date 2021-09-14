package com.jacob.educamep;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TableLayout;

public class AsignacionEstudiantesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.asignacionestudiantes);
        Spinner comboBoxCedulas = findViewById(R.id.sCedulas);
        Spinner comboBoxCursos = findViewById(R.id.sCursos);
        TableLayout tblCursos = findViewById(R.id.tableCursos);
        //-------------------------------------------------------
        final Button btnEliminarCurso = findViewById(R.id.btnEliminarsCurso);
        final Button btnAgregarCurso = findViewById(R.id.btnAgregarCurso);
        final Button btnAtras = findViewById(R.id.btnAtras);
        final Button btnConfirmar = findViewById(R.id.btnConfirmar);

    }
}