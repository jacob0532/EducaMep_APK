package com.jacob.educamep;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.jacob.educamep.clasesLogicas.Administrador;
import com.jacob.educamep.clasesLogicas.BDEducaMep;
import com.jacob.educamep.clasesLogicas.Curso;
import com.jacob.educamep.clasesLogicas.Curso.*;
import com.jacob.educamep.clasesLogicas.Horario;

import java.util.ArrayList;

public class AgregarCursoActivity extends AppCompatActivity{
    ArrayList<Horario> horarios = new ArrayList<Horario>();
    String grado;
    String dia;
    String hora1;
    String hora2;
    int idEliminarHorario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agregarcurso);
        final EditText txtNombre = findViewById(R.id.tbNombreCurso);
        final Spinner comboBoxGradoEsc = findViewById(R.id.sGrado);
        final Spinner comboBoxDia = findViewById(R.id.sDia);
        final Spinner comboBoxHR1 = findViewById(R.id.sInicio);
        final Spinner comboBoxHR2 = findViewById(R.id.sFin);
        //--------------------------------------------------------------------
        final Button btnEliminarHora = findViewById(R.id.btnEliminarHora);
        final Button btnAgregarHora = findViewById(R.id.btnAgregarHora);
        final Button btnAtras = findViewById(R.id.btnAtras);
        final Button btnConfirmar = findViewById(R.id.btnConfirmar);
        final TableLayout tablaHorarios = findViewById(R.id.tableHorarios);
        crearTabla(tablaHorarios);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.diasSpinner, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        comboBoxDia.setAdapter(adapter);
        comboBoxDia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String text = comboBoxDia.getSelectedItem().toString();
                dia = text;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //---------------------------------
        //---------------------------------
        //---------------------------------
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.horasSpinner, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        comboBoxHR1.setAdapter(adapter2);
        comboBoxHR1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String text = comboBoxHR1.getSelectedItem().toString();
                hora1 = text;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //---------------------------------
        //---------------------------------
        //---------------------------------
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.horasSpinner, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        comboBoxHR2.setAdapter(adapter3);
        comboBoxHR2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String text = comboBoxHR2.getSelectedItem().toString();
                hora2 = text;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //---------------------------------
        //---------------------------------
        //---------------------------------
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
        btnAgregarHora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llenarTabla(tablaHorarios,dia,hora1,hora2);
            }
        });
        btnEliminarHora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eliminarHorario(tablaHorarios);

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
        BDEducaMep bd = new BDEducaMep(AgregarCursoActivity.this,a,1,1);
        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String varNombre = txtNombre.getText().toString();
                bd.execute(varNombre,grado,horarios);
                Intent siguiente = new Intent(v.getContext(),AgregarCursoActivity.class);
                startActivity(siguiente);
            }
        });

    }
    //FUNCIONES DE HORARIO
    protected void crearTabla(TableLayout tablaHorarios){
        tablaHorarios.setStretchAllColumns(true);
        tablaHorarios.setWeightSum(3);
        // crear fila con las guias de la tabla
        TableRow tr0 = new TableRow(this);
        tr0.setId(-1);
        // textViews para la informacion de las guias
        TextView tv0 = new TextView(this);
        tv0.setText("Día");
        tv0.setTextColor(Color.BLUE);
        TextView tv1 = new TextView(this);
        tv1.setText("Hora Inicial");
        tv1.setTextColor(Color.BLUE);
        TextView tv2 = new TextView(this);
        tv2.setText("Hora Final");
        tv2.setTextColor(Color.BLUE);
        // se añaden los textview a la guia
        tr0.addView(tv0);
        tr0.addView(tv1);
        tr0.addView(tv2);
        // se añade la fila de guias a la tabla
        tablaHorarios.addView(tr0);
        // se añaden a la tabla
    }
    protected void llenarTabla(TableLayout tablaHorarios,String diax, String hora1x,String hora2x){
        if(diax.equals("") || hora1x.equals("") || hora2x.equals("")){
            return;
        }
        Horario hr = new Horario(hora1x,hora2x,diax);
        horarios.add(hr);
        tablaHorarios.removeAllViews();
        for (int i=0;i<horarios.size();i++){
            TableRow tr = new TableRow(this);
            tr.setId(i);

            TextView tv = new TextView(this);
            tv.setText(horarios.get(i).dia);
            tv.setTextColor(Color.BLACK);
            TextView tv2 = new TextView(this);
            tv2.setText(horarios.get(i).horaInicial);
            tv2.setTextColor(Color.BLACK);
            TextView tv3 = new TextView(this);
            tv3.setText(horarios.get(i).horaFinal);
            tv3.setTextColor(Color.BLACK);
            tr.addView(tv);
            tr.addView(tv2);
            tr.addView(tv3);
            // click de la fila
            tr.setClickable(true);
            int finalI = i;
            tr.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v)
                {
                    tr.setBackgroundColor(Color.RED);
                    idEliminarHorario = finalI;

                }
            });
            tablaHorarios.addView(tr);

        }
    }
    protected void eliminarHorario(TableLayout tablaHorarios){
        tablaHorarios.removeAllViews();
        if(idEliminarHorario==0){
            return;
        }
        else{
            horarios.remove(idEliminarHorario);
            idEliminarHorario=0;
            for (int i=0;i<horarios.size();i++){
                TableRow tr = new TableRow(this);
                tr.setId(i);

                TextView tv = new TextView(this);
                tv.setText(horarios.get(i).dia);
                tv.setTextColor(Color.BLACK);
                TextView tv2 = new TextView(this);
                tv2.setText(horarios.get(i).horaInicial);
                tv2.setTextColor(Color.BLACK);
                TextView tv3 = new TextView(this);
                tv3.setText(horarios.get(i).horaFinal);
                tv3.setTextColor(Color.BLACK);
                tr.addView(tv);
                tr.addView(tv2);
                tr.addView(tv3);
                // click de la fila
                tr.setClickable(true);
                int finalI = i;
                tr.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v)
                    {
                        tr.setBackgroundColor(Color.RED);
                        idEliminarHorario = finalI;
                    }
                });
                tablaHorarios.addView(tr);

            }

        }

    }
}