package com.jacob.educamep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableLayout;

import com.jacob.educamep.clasesLogicas.Administrador;
import com.jacob.educamep.clasesLogicas.BDEducaMep;

import java.util.ArrayList;

public class ModificarCursoActivity extends AppCompatActivity {
    String text;
    String grado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modificarcurso);
        final Spinner comboBoxCurso = findViewById(R.id.sCurso);
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

        ArrayList<String[]> list = (ArrayList<String[]>) getIntent().getSerializableExtra("list");
        final ArrayList<String> arregloStringsCursos = new ArrayList<String>();
        for (int i=0;i<list.size();i++){
            arregloStringsCursos.add(list.get(i)[0] + "-" + list.get(i)[1] + "-" + list.get(i)[2]);
            Log.d("mi app",arregloStringsCursos.get(i));
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arregloStringsCursos);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        comboBoxCurso.setAdapter(adapter);
        comboBoxCurso.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] arr = comboBoxCurso.getSelectedItem().toString().split("-");
                text = arr[0];
                Log.d("lalala",text);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this, R.array.gradosSpinner, android.R.layout.simple_spinner_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        comboBoxGradoEsc.setAdapter(adapter4);
        comboBoxGradoEsc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String text = comboBoxGradoEsc.getSelectedItem().toString();
                grado = text;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent anterior = new Intent(v.getContext(),GestionCursosActivity.class);
                startActivity(anterior);
            }
        });
        Administrador a = new Administrador(0,null,null,null,null,null);
        BDEducaMep bd = new BDEducaMep(ModificarCursoActivity.this,a,1,3);
        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = txtNombre.getText().toString();
                bd.execute(text,nombre,grado);
                Intent anterior = new Intent(v.getContext(),GestionCursosActivity.class);
                startActivity(anterior);
            }
        });

    }
}