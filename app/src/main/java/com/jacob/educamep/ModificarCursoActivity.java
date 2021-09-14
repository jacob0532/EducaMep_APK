package com.jacob.educamep;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableLayout;

public class ModificarCursoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modificarcurso);
        final Spinner comboBoxCursos = findViewById(R.id.sCursos);
        final EditText txtNombre = findViewById(R.id.tbNombreCurso);
        final Spinner comboBoxGradoEsc = findViewById(R.id.sGrado);
        final Spinner comboBoxDia = findViewById(R.id.sDia);
        final Spinner comboBoxHR1 = findViewById(R.id.sInicio);
        final Spinner comboBoxHR2 = findViewById(R.id.sFin);
        final TableLayout tablaHorarios = findViewById(R.id.tableHorarios);
        //--------------------------------------------------------------------
        final Button btnEliminarHora = findViewById(R.id.btnEliminarHora);
        final Button btnAgregarHora = findViewById(R.id.btnAgregarHora);
        final Button btnAtras = findViewById(R.id.btnAtras);
        final Button btnConfirmar = findViewById(R.id.btnConfirmar);
    }
}