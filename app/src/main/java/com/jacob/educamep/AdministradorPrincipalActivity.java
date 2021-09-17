package com.jacob.educamep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.jacob.educamep.clasesLogicas.Administrador;
import com.jacob.educamep.clasesLogicas.BDEducaMep;
import com.jacob.educamep.clasesLogicas.Docente;
import com.jacob.educamep.clasesLogicas.Estudiante;
import com.jacob.educamep.clasesLogicas.Usuario;

import java.util.ArrayList;

public class AdministradorPrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.administradorprincipal);
        final Button btnCursos = findViewById(R.id.btnCursos);
        final Button btnDocentes = findViewById(R.id.btnDocentes);
        final Button btnEstudiantes = findViewById(R.id.btnEstudiantes);
        final Button btnAsignacion = findViewById(R.id.btnAsignacion);
        final Button btnSalir = findViewById(R.id.btnSalir);
        //Usuario usuario2 = (Usuario) getIntent().getSerializableExtra("usuario");
        //Administrador usuario = new Administrador(usuario2.cedula,usuario2.nombre, usuario2.apellido1,usuario2.apellido2,usuario2.correoElectronico, usuario2.contraseña);
        //Log.d("EJEMPLO",usuario.nombre);
        btnCursos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent siguiente = new Intent(v.getContext(),GestionCursosActivity.class);
                startActivity(siguiente);
            }
        });
        btnDocentes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent atras = new Intent(v.getContext(),GestionDocentesActivity.class);
                startActivity(atras);

            }
        });
        btnEstudiantes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent atras = new Intent(v.getContext(),GestionEstudiantesActivity.class);
                startActivity(atras);

            }
        });
        btnAsignacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent atras = new Intent(v.getContext(),GestionAsignacionesActivity.class);
                startActivity(atras);

            }
        });
        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent atras = new Intent(v.getContext(),LoginSelectActivity.class);
                startActivity(atras);
            }
        });
    }
}