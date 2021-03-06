package com.jacob.educamep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TextView;

import com.jacob.educamep.clasesLogicas.Administrador;
import com.jacob.educamep.clasesLogicas.BDEducaMep;

import java.util.ArrayList;

public class EliminarCursoActivity extends AppCompatActivity {
    String text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eliminarcurso);
        final Spinner comboBoxCurso = findViewById(R.id.sCurso);
        final TextView lblNombre = findViewById(R.id.tvNombreCurso);
        final TextView lblGrado = findViewById(R.id.tvGradoDelCurso);
        final TableLayout tblHorarios = findViewById(R.id.tableHorarios);
        final Button btnEliminar = findViewById(R.id.btnEliminar);
        final Button btnAtras = findViewById(R.id.btnAtras);
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
                lblNombre.setText(arr[1]);
                lblGrado.setText(arr[2]);
                Log.d("lalala",text);
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
        BDEducaMep bd = new BDEducaMep(EliminarCursoActivity.this,a,1,4);
        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bd.execute(text);
                Intent anterior = new Intent(v.getContext(),GestionCursosActivity.class);
                startActivity(anterior);
            }
        });
    }
}