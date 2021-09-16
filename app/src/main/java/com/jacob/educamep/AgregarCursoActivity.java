package com.jacob.educamep;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TextView;

public class AgregarCursoActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agregarcurso);
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

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.diasSpinner, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        comboBoxDia.setAdapter(adapter);
        comboBoxDia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String text = comboBoxDia.getSelectedItem().toString();
                Log.d("TEXTO DEL DIA",text);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}