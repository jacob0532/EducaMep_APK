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

import com.jacob.educamep.clasesLogicas.Estudiante;

import java.util.ArrayList;

public class ListaNoticiasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listanoticias);
        final TextView lblCurso = findViewById(R.id.tvCursoActual);
        final Button btnAtras = findViewById(R.id.btnAtras);

        String id = (String) getIntent().getSerializableExtra("idCurso");
        lblCurso.setText(id);
        ArrayList<String[]> list = (ArrayList<String[]>) getIntent().getSerializableExtra("listN");

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
                Bundle b = new Bundle();
                b.putSerializable("list", getIntent().getSerializableExtra("list"));
                anterior.putExtras(b);
                startActivity(anterior);
            }
        });
    }
    protected void fillTable(ArrayList<String[]> noticias) {
        TableLayout table = findViewById(R.id.tablaNoticias);
        table.setStretchAllColumns(true);
        table.setWeightSum(2); //numero de columnas

        // crear fila con las guias de la tabla
        TableRow tr0 = new TableRow(this);
        tr0.setId(-1);
        // textViews para la informacion de las guias
        TextView tv0 = new TextView(this);
        tv0.setText("Fecha");
        tv0.setTextColor(Color.BLUE);
        TextView tv1 = new TextView(this);
        tv1.setText("Titulo");
        tv1.setTextColor(Color.BLUE);
        // se a??aden los textview a la guia
        tr0.addView(tv0);
        tr0.addView(tv1);
        // se a??ade la fila de guias a la tabla
        table.addView(tr0);
        // se a??aden a la tabla
        for (int i=0; i< noticias.size(); i++){
            TableRow tr = new TableRow(this);
            tr.setId(i);

            TextView tv = new TextView(this);
            tv.setText(noticias.get(i)[3]);
            tv.setTextColor(Color.BLACK);
            TextView tv2 = new TextView(this);
            tv2.setText(noticias.get(i)[1]);
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
                    Intent siguiente = new Intent(v.getContext(), VerNoticiaActivity.class);
                    Bundle b = new Bundle();
                    b.putSerializable("usuario", usuario);
                    b.putSerializable("idCurso", id);
                    b.putSerializable("idNoticia", String.valueOf(noticias.get(finalI)[0]));
                    b.putSerializable("titulo", String.valueOf(noticias.get(finalI)[1]));
                    b.putSerializable("descripcion", String.valueOf(noticias.get(finalI)[2]));
                    b.putSerializable("fecha", String.valueOf(noticias.get(finalI)[3]));
                    b.putSerializable("list", getIntent().getSerializableExtra("list"));
                    b.putSerializable("listN", getIntent().getSerializableExtra("listN"));
                    siguiente.putExtras(b);
                    startActivity(siguiente);
                }
            });
            // a??adir a la tabla
            table.addView(tr);
        }
    }
}