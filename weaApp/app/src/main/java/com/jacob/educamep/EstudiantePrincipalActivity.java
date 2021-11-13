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

import com.jacob.educamep.clasesLogicas.Administrador;
import com.jacob.educamep.clasesLogicas.BDEducaMep;
import com.jacob.educamep.clasesLogicas.Estudiante;
import com.jacob.educamep.clasesLogicas.Usuario;

import java.io.Serializable;
import java.util.ArrayList;

public class EstudiantePrincipalActivity extends AppCompatActivity {
    String text="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.estudianteprincipal);
        final Spinner comboBoxCursos = findViewById(R.id.sCursos);
        final Button btnProfesorEncargado = findViewById(R.id.btnProfesor);
        final Button btnNoticia = findViewById(R.id.btnNoticia);
        final Button btnTarea = findViewById(R.id.btnTarea);
        final Button btnChat = findViewById(R.id.btnChat);
        final Button btnSalir = findViewById(R.id.btnSalir);
        Usuario usuario2 = (Usuario) getIntent().getSerializableExtra("usuario");
        Estudiante usuario = new Estudiante(usuario2.cedula,usuario2.nombre, usuario2.apellido1,usuario2.apellido2,usuario2.correoElectronico, usuario2.contraseña,"",null);
        Log.d("EJEMPLO",usuario.nombre);

        final ArrayList<String[]> list = (ArrayList<String[]>) getIntent().getSerializableExtra("list");
        final ArrayList<String> arregloStringsCursos = new ArrayList<String>();
        for (int i=0;i<list.size();i++){
            arregloStringsCursos.add(list.get(i)[0] + "-" + list.get(i)[1] + "-" + list.get(i)[2]);
            Log.d("mi app",arregloStringsCursos.get(i));
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arregloStringsCursos);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        comboBoxCursos.setAdapter(adapter);
        comboBoxCursos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] arr = comboBoxCursos.getSelectedItem().toString().split("-");
                text = arr[0];
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnProfesorEncargado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Prueba
                //Estudiante usuario = new Estudiante(123456, "pepito", "Ramirez", "Mora", "pepito@gmail.com", "superpepito", 5, null);
                //BDEducaMep db = new BDEducaMep(EstudiantePrincipalActivity.this, (Usuario) usuario, 4, 1);
                //db.execute(1);
                //Estudiante usuario = (Estudiante) getIntent().getSerializableExtra("usuario");
                BDEducaMep db = new BDEducaMep(view.getContext(), usuario, 4, 1);
                db.execute(Integer.parseInt(text));
                while(db.resultado2 == null){
                    Log.d("MI OPPPOPOPO", "loading...");
                }
                if (db.resultado2.isEmpty()){
                    Toast.makeText(view.getContext(), "no hay un profesor asignado",Toast.LENGTH_LONG).show();
                }else{
                    Intent send = new Intent(view.getContext(),PerfilDocenteActivity.class);
                    Bundle b = new Bundle();
                    b.putSerializable("profesor", (ArrayList<String[]>)db.resultado2);
                    b.putSerializable("idCurso", (String) comboBoxCursos.getSelectedItem());
                    b.putSerializable("list", list);
                    //b.putSerializable("idCurso", "1");
                    send.putExtras(b);
                    startActivity(send);
                }
            }
        });

        btnNoticia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Prueba
                //Estudiante usuario = new Estudiante(123456, "pepito", "Ramirez", "Mora", "pepito@gmail.com", "superpepito", 5, null);
                //BDEducaMep db = new BDEducaMep(EstudiantePrincipalActivity.this, (Usuario) usuario, 1, 1);
                //db.execute(1);
                //Estudiante usuario = (Estudiante) getIntent().getSerializableExtra("usuario");
                BDEducaMep db = new BDEducaMep(view.getContext(), usuario, 1, 1);
                db.execute(Integer.parseInt(text));
                while(db.resultado2 == null){
                    Log.d("MI OPPPOPOPO", "loading...");
                }
                if (db.resultado2.isEmpty()){
                    Toast.makeText(view.getContext(), "no tiene noticias asignadas",Toast.LENGTH_LONG).show();
                }else {
                    Intent send = new Intent(view.getContext(), ListaNoticiasActivity.class);
                    Bundle b = new Bundle();
                    b.putSerializable("listN", (ArrayList<String[]>) db.resultado2);
                    b.putSerializable("idCurso", (String) comboBoxCursos.getSelectedItem());
                    b.putSerializable("list", list);
                    //b.putSerializable("idCurso", "1");
                    send.putExtras(b);
                    startActivity(send);
                }
            }
        });

        btnTarea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Prueba
                //Estudiante usuario = new Estudiante(123456, "pepito", "Ramirez", "Mora", "pepito@gmail.com", "superpepito", 5, null);
                //BDEducaMep db = new BDEducaMep(EstudiantePrincipalActivity.this, (Usuario) usuario, 2, 1);
                //db.execute(1);
                //Estudiante usuario = (Estudiante) getIntent().getSerializableExtra("usuario");
                BDEducaMep db = new BDEducaMep(view.getContext(), usuario, 2, 1);
                db.execute(Integer.parseInt(text));
                while(db.resultado2 == null){
                    Log.d("MI OPPPOPOPO", "loading...");
                }
                if (db.resultado2.isEmpty()){
                    Toast.makeText(view.getContext(), "no tiene tareas asignadas",Toast.LENGTH_LONG).show();
                }else {
                    Intent send = new Intent(view.getContext(), ListaTareasActivity.class);
                    Bundle b = new Bundle();
                    b.putSerializable("listT", (ArrayList<String[]>) db.resultado2);
                    b.putSerializable("idCurso", (String) comboBoxCursos.getSelectedItem());
                    b.putSerializable("list", list);
                    //b.putSerializable("idCurso", "1");
                    send.putExtras(b);
                    startActivity(send);
                }
            }
        });
    }
}