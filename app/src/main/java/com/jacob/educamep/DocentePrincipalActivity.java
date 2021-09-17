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
import android.widget.Toast;

import com.jacob.educamep.clasesLogicas.BDEducaMep;
import com.jacob.educamep.clasesLogicas.Docente;
import com.jacob.educamep.clasesLogicas.Estudiante;
import com.jacob.educamep.clasesLogicas.Usuario;

import java.util.ArrayList;

import com.jacob.educamep.clasesLogicas.Docente;
import com.jacob.educamep.clasesLogicas.Estudiante;

public class DocentePrincipalActivity extends AppCompatActivity {
    String text="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.docenteprincipal);
        Spinner comboBoxCurso = findViewById(R.id.sCursos);
        Button btnPublicarNoticia = findViewById(R.id.btnNoticia);
        Button btnAsignarTarea = findViewById(R.id.btnTarea);
        Button btnListaEstudiantes = findViewById(R.id.btnLista);
        Button btnChatCurso = findViewById(R.id.btnChat);
        Button btnSalir = findViewById(R.id.btnSalir);


        Docente usuario = new Docente(0,null, null,null,null, null,0,null);
        //Log.d("EJEMPLO",usuario.nombre);

        final ArrayList<String[]> list = (ArrayList<String[]>) getIntent().getSerializableExtra("list");
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
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        btnPublicarNoticia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Prueba
                //Docente usuario = new Docente(123456, "pepito", "Ramirez", "Mora", "pepito@gmail.com", "superpepito", 5, null);
                Intent send = new Intent(view.getContext(), AgregarNoticiaActivity.class);
                Bundle b = new Bundle();
                b.putSerializable("idCurso", (String) text);
                //b.putSerializable("idCurso", "1");
                b.putSerializable("usuario", usuario);
                b.putSerializable("list", list);
                send.putExtras(b);
                startActivity(send);
            }
        });

        btnListaEstudiantes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Prueba
                //Docente usuario = new Docente(123456, "pepito", "Ramirez", "Mora", "pepito@gmail.com", "superpepito", 5, null);
                //BDEducaMep db = new BDEducaMep(DocentePrincipalActivity.this, (Usuario) usuario, 4, 1);
                //db.execute(1);
                BDEducaMep db = new BDEducaMep(view.getContext(), usuario, 4, 1);
                db.execute(Integer.parseInt(text));
                while(db.resultado2 == null){
                    Log.d("MI OPPPOPOPO", "loading...");
                }
                if (db.resultado2.isEmpty()){
                    Toast.makeText(view.getContext(), "no hay estudiantes asignados",Toast.LENGTH_LONG).show();
                }else{
                    Intent send = new Intent(view.getContext(),ListaEstudiantesActivity.class);
                    Bundle b = new Bundle();
                    b.putSerializable("listEst", (ArrayList<String[]>)db.resultado2);
                    b.putSerializable("idCurso", text);
                    //b.putSerializable("idCurso", "1");
                    b.putSerializable("list", list);
                    send.putExtras(b);
                    startActivity(send);
                }
            }
        });

        btnAsignarTarea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Prueba
                Docente usuario = new Docente(123456, "pepito", "Ramirez", "Mora", "pepito@gmail.com", "superpepito", 5, null);
                //Docente usuario = (Docente) getIntent().getSerializableExtra("usuario");
                Intent send = new Intent(view.getContext(), AgregarTareaActivity.class);
                Bundle b = new Bundle();
                //b.putSerializable("idCurso", (String) comboBoxCursos.getSelectedItem());
                b.putSerializable("idCurso", text);
                b.putSerializable("list", list);
                b.putSerializable("usuario", usuario);
                send.putExtras(b);
                startActivity(send);
            }
        });

    }
}