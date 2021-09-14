package com.jacob.educamep;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableLayout;

public class AgregarDocenteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agregardocente);
        //--------------------------------------------------------------------
        final EditText txtCedula = findViewById(R.id.tbCedula);
        final EditText txtNombre = findViewById(R.id.tbNombre);
        final EditText txtPrimerApellido = findViewById(R.id.tbPrimerApellido);
        final EditText txtSegundoApellido = findViewById(R.id.tbSegundoApellido);
        final EditText txtCorreo = findViewById(R.id.tbCorreo);
        //-------------------------------------------------------
        final Spinner comboBoxCursos = findViewById(R.id.sCursos);
        final TableLayout tablaCursos = findViewById(R.id.tableCursos);
        //-------------------------------------------------------
        final Button btnEliminarCurso = findViewById(R.id.btnEliminarsCurso);
        final Button btnAgregarCurso = findViewById(R.id.btnAgregarCurso);
        final Button btnAtras = findViewById(R.id.btnAtras);
        final Button btnConfirmar = findViewById(R.id.btnConfirmar);
    }
}