package com.jacob.educamep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.jacob.educamep.clasesLogicas.BDEducaMep;
import com.jacob.educamep.clasesLogicas.Estudiante;
import com.jacob.educamep.clasesLogicas.Usuario;

import java.util.ArrayList;

public class ListaTareasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listatareas);
        final TextView lblCurso = findViewById(R.id.tvCursoActual);
        final TableLayout tblTareas = findViewById(R.id.tablaTareas);
        final Button btnAtras = findViewById(R.id.btnAtras);
        //Prueba
        //Estudiante usuario = new Estudiante(123456, "pepito", "Ramirez", "Mora", "pepito@gmail.com", "superpepito", 5, null);
        //BDEducaMep db = new BDEducaMep(ListaTareasActivity.this, (Usuario) usuario, 2, 1);
        //db.execute(1);
        BDEducaMep db = new BDEducaMep(ListaTareasActivity.this, (Usuario) getIntent().getSerializableExtra("usuario"), 2, 1);
        db.execute((int) getIntent().getSerializableExtra("idCurso"));

        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent anterior = new Intent(view.getContext(),EstudiantePrincipalActivity.class);
                startActivity(anterior);
            }
        });
    }
    /*protected void fillTable() {
        TableLayout table = findViewById(R.id.tablaTareas);
        table.setStretchAllColumns(true);
        table.setWeightSum(3); //numero de columnas

        // crear fila con las guias de la tabla
        TableRow tr0 = new TableRow(this);
        tr0.setId(-1);
        // textViews para la informacion de las guias
        TextView tv0 = new TextView(this);
        tv0.setText("Cedula");
        tv0.setTextColor(Color.BLUE);
        TextView tv1 = new TextView(this);
        tv1.setText("Nombre");
        tv1.setTextColor(Color.BLUE);
        TextView tv2 = new TextView(this);
        tv2.setText("Grado");
        tv2.setTextColor(Color.BLUE);
        // se añaden los textview a la guia
        tr0.addView(tv1);
        tr0.addView(tv0);
        tr0.addView(tv2);
        // se añade la fila de guias a la tabla
        table.addView(tr0);

        // contenidos de la base de datos
        ArrayList<String[]> students = getList();
        // se añaden a la tabla
        for (int i=0; i< students.size(); i++){
            TableRow tr = new TableRow(this);
            tr.setId(i);
            for (int j=0; j< students.get(i).length; j++){
                TextView tv = new TextView(this);
                tv.setText(students.get(i)[j]);
                tv.setTextColor(Color.BLACK);
                tr.addView(tv);
            }
            // click de la fila
            tr.setClickable(true);
            tr.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v)
                {
                    Button btn = findViewById(R.id.btnExample);
                    btn.setText(students.get(tr.getId())[1]);
                }
            });
            // añadir a la tabla
            table.addView(tr);
        }
    }*/
}