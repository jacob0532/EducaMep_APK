package com.jacob.educamep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.jacob.educamep.clasesLogicas.BDEducaMep;
import com.jacob.educamep.clasesLogicas.Estudiante;
import com.jacob.educamep.clasesLogicas.Usuario;

import java.util.ArrayList;
import java.util.EventListener;

public class ListaTareasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listatareas);
        final TextView lblCurso = findViewById(R.id.tvCursoActual);
        final TableLayout tblTareas = findViewById(R.id.tablaTareas);
        final Button btnAtras = findViewById(R.id.btnAtras);
        String id = (String) getIntent().getSerializableExtra("idCurso");
        lblCurso.setText(id);
        ArrayList<String[]> list = (ArrayList<String[]>) getIntent().getSerializableExtra("list");

        //to-do eliminar Prueba
        /*ArrayList<String[]> list = new ArrayList<String[]>();
        String[] str1 = {"1", "Prueba", "la prueba", "2021-09-08", "2021-08-08"};
        String[] str2 = {"3", "Pruebasa", "la prueba definitiva", "2021-08-08", "2021-02-08"};
        list.add(str1);
        list.add(str2);
        // prueba lista
        for (int i=0; i<list.size(); i++){
            for(int j=0; j<list.get(i).length;j++){
                Log.d("MI OPPPOPOPO", list.get(i)[j]);
            }
            Log.d("MI OPPPOPOPO", "=================");
        }*/

        fillTable(list);

        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent anterior = new Intent(view.getContext(),EstudiantePrincipalActivity.class);
                startActivity(anterior);
            }
        });
    }
    protected void fillTable(ArrayList<String[]> tareas) {
        TableLayout table = findViewById(R.id.tablaTareas);
        table.setStretchAllColumns(true);
        table.setWeightSum(2); //numero de columnas

        // crear fila con las guias de la tabla
        TableRow tr0 = new TableRow(this);
        tr0.setId(-1);
        // textViews para la informacion de las guias
        TextView tv0 = new TextView(this);
        tv0.setText("Titulo");
        tv0.setTextColor(Color.BLUE);
        TextView tv1 = new TextView(this);
        tv1.setText("Fecha Entrega");
        tv1.setTextColor(Color.BLUE);
        // se añaden los textview a la guia
        tr0.addView(tv1);
        tr0.addView(tv0);
        // se añade la fila de guias a la tabla
        table.addView(tr0);
        // se añaden a la tabla
        for (int i=0; i< tareas.size(); i++){
            TableRow tr = new TableRow(this);
            tr.setId(i);

            TextView tv = new TextView(this);
            tv.setText(tareas.get(i)[1]);
            tv.setTextColor(Color.BLACK);
            TextView tv2 = new TextView(this);
            tv2.setText(tareas.get(i)[3]);
            tv2.setTextColor(Color.BLACK);
            tr.addView(tv);
            tr.addView(tv2);

            // click de la fila
            tr.setClickable(true);
            int finalI = i;
            tr.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v)
                {
                    Estudiante usuario = (Estudiante) getIntent().getSerializableExtra("usuario");
                    String id = (String) getIntent().getSerializableExtra("idCurso");
                    Intent siguiente = new Intent(v.getContext(), VerTareaActivity.class);
                    Bundle b = new Bundle();
                    b.putSerializable("usuario", usuario);
                    b.putSerializable("idCurso", id);
                    b.putSerializable("idTarea", String.valueOf(tareas.get(finalI)[0]));
                    b.putSerializable("titulo", String.valueOf(tareas.get(finalI)[1]));
                    b.putSerializable("descripcion", String.valueOf(tareas.get(finalI)[2]));
                    b.putSerializable("fechaE", String.valueOf(tareas.get(finalI)[3]));
                    b.putSerializable("fechaA", String.valueOf(tareas.get(finalI)[4]));
                    siguiente.putExtras(b);
                    startActivity(siguiente);
                }
            });
            // añadir a la tabla
            table.addView(tr);
        }
    }
}