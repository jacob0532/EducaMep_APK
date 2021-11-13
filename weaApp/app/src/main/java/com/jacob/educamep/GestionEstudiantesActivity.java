package com.jacob.educamep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.jacob.educamep.clasesLogicas.Administrador;
import com.jacob.educamep.clasesLogicas.BDEducaMep;
import com.jacob.educamep.clasesLogicas.Estudiante;
import com.jacob.educamep.clasesLogicas.Usuario;

import java.util.ArrayList;

public class GestionEstudiantesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gestionestudiantes);
        final Button btnAgregar = findViewById(R.id.btnAgregar);
        final Button btnEliminar = findViewById(R.id.btnEliminar);
        final Button btnModificar = findViewById(R.id.btnModificar);
        final Button btnAtras = findViewById(R.id.btnAtras);
        
        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Prueba
                Administrador usuario = new Administrador(123456, "pepito", "Ramirez", "Mora", "pepito@gmail.com", "superpepito");
                BDEducaMep db = new BDEducaMep(GestionEstudiantesActivity.this, (Usuario) usuario, 3, 2);
                db.execute();
                //Estudiante usuario = (Estudiante) getIntent().getSerializableExtra("usuario");
                //BDEducaMep db = new BDEducaMep(view.getContext(), usuario, 4, 1);
                //db.execute((int) getIntent().getSerializableExtra("idCurso"));
                while(db.resultado2 == null){
                    Log.d("MI OPPPOPOPO", "loading...");
                }
                if (db.resultado2.isEmpty()){
                    Toast.makeText(view.getContext(), "no hay un profesor asignado",Toast.LENGTH_LONG).show();
                }else{
                    Intent send = new Intent(view.getContext(),EliminarEstudianteActivity.class);
                    Bundle b = new Bundle();
                    b.putSerializable("estudiantes", (ArrayList<String[]>)db.resultado2);
                    send.putExtras(b);
                    startActivity(send);
                }
            }
        });
        
        btnModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Prueba
                Administrador usuario = new Administrador(123456, "pepito", "Ramirez", "Mora", "pepito@gmail.com", "superpepito");
                BDEducaMep db = new BDEducaMep(GestionEstudiantesActivity.this, (Usuario) usuario, 3, 2);
                db.execute();
                //Estudiante usuario = (Estudiante) getIntent().getSerializableExtra("usuario");
                //BDEducaMep db = new BDEducaMep(view.getContext(), usuario, 4, 1);
                //db.execute((int) getIntent().getSerializableExtra("idCurso"));
                while(db.resultado2 == null){
                    Log.d("MI OPPPOPOPO", "loading...");
                }
                if (db.resultado2.isEmpty()){
                    Toast.makeText(view.getContext(), "no hay un profesor asignado",Toast.LENGTH_LONG).show();
                }else{
                    Intent send = new Intent(view.getContext(),ModificarEstudianteActivity.class);
                    Bundle b = new Bundle();
                    b.putSerializable("estudiantes", (ArrayList<String[]>)db.resultado2);
                    send.putExtras(b);
                    startActivity(send);
                }
            }
        });
        
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent anterior = new Intent(view.getContext(),AgregarEstudianteActivity.class);
                startActivity(anterior);
            }
        });
        
        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent anterior = new Intent(view.getContext(),AdministradorPrincipalActivity.class);
                startActivity(anterior);
            }
        });

    }
}
