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

import com.jacob.educamep.clasesLogicas.Docente;
import com.jacob.educamep.clasesLogicas.Estudiante;

import java.util.ArrayList;

public class ListaEstudiantesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listaestudiantes);
        final TextView lblCurso = findViewById(R.id.tvCursoActual);
        final TableLayout tblEstudiante = findViewById(R.id.tablaEstudiantes);
        final Button btnAtras = findViewById(R.id.btnAtras);

        String id = (String) getIntent().getSerializableExtra("idCurso");
        lblCurso.setText(id);
        ArrayList<String[]> list = (ArrayList<String[]>) getIntent().getSerializableExtra("list");
        fillTable(list);

        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent anterior = new Intent(view.getContext(),DocentePrincipalActivity.class);
                startActivity(anterior);
            }
        });
    }
    protected void fillTable(ArrayList<String[]> estudiantes) {
        TableLayout table = findViewById(R.id.tablaEstudiantes);
        table.setStretchAllColumns(true);
        table.setWeightSum(2); //numero de columnas

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
        // se añaden los textview a la guia
        tr0.addView(tv0);
        tr0.addView(tv1);
        // se añade la fila de guias a la tabla
        table.addView(tr0);
        // se añaden a la tabla
        for (int i = 0; i < estudiantes.size(); i++) {
            TableRow tr = new TableRow(this);
            tr.setId(i);

            TextView tv = new TextView(this);
            tv.setText(estudiantes.get(i)[0]);
            tv.setTextColor(Color.BLACK);
            TextView tv2 = new TextView(this);
            String nombreCompleto = estudiantes.get(i)[1] + " " + estudiantes.get(i)[2] + " " + estudiantes.get(i)[3];
            tv2.setText(nombreCompleto);
            tv2.setTextColor(Color.BLACK);
            tr.addView(tv);
            tr.addView(tv2);

            // click de la fila
            tr.setClickable(true);
            int finalI = i;
            tr.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Docente usuario = (Docente) getIntent().getSerializableExtra("usuario");
                    String id = (String) getIntent().getSerializableExtra("idCurso");
                    Intent siguiente = new Intent(v.getContext(), PerfilEstudianteActivity.class);
                    Bundle b = new Bundle();
                    b.putSerializable("usuario", usuario);
                    b.putSerializable("idCurso", id);
                    b.putSerializable("cedula", String.valueOf(estudiantes.get(finalI)[0]));
                    b.putSerializable("nombre", String.valueOf(estudiantes.get(finalI)[1]));
                    b.putSerializable("primer", String.valueOf(estudiantes.get(finalI)[2]));
                    b.putSerializable("segundo", String.valueOf(estudiantes.get(finalI)[3]));
                    b.putSerializable("correo", String.valueOf(estudiantes.get(finalI)[4]));
                    b.putSerializable("grado", String.valueOf(estudiantes.get(finalI)[5]));
                    siguiente.putExtras(b);
                    startActivity(siguiente);
                }
            });
            // añadir a la tabla
            table.addView(tr);
        }
    }
}