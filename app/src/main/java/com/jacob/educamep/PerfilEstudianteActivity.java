package com.jacob.educamep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class PerfilEstudianteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.perfilestudiante);
        final TextView lblNombreCurso = findViewById(R.id.tvCursoActual);
        final TextView lblNombreEstudiante= findViewById(R.id.tvNombre2);
        final TextView lblPrimerApellido= findViewById(R.id.tvPrimerApellido2);
        final TextView lblSegundoApellido= findViewById(R.id.tvSegundoApellido2);
        final TextView lblCedula = findViewById(R.id.tvCarnet2);
        final TextView lblGradoEscolar = findViewById(R.id.tvGrado2);
        final TextView lblCorreo = findViewById(R.id.tvCorreo2);
        final Button btnAtras = findViewById(R.id.btnAtras);

        String id = (String) getIntent().getSerializableExtra("idCurso");
        lblNombreCurso.setText(id);
        String cedula = (String) getIntent().getSerializableExtra("cedula");
        lblCedula.setText(cedula);
        String nombre = (String) getIntent().getSerializableExtra("nombre");
        lblNombreEstudiante.setText(nombre);
        String primer = (String) getIntent().getSerializableExtra("primer");
        lblPrimerApellido.setText(primer);
        String segundo = (String) getIntent().getSerializableExtra("segundo");
        lblSegundoApellido.setText(segundo);
        String grado = (String) getIntent().getSerializableExtra("grado");
        lblGradoEscolar.setText(grado);
        String correo = (String) getIntent().getSerializableExtra("correo");
        lblCorreo.setText(correo);

        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent anterior = new Intent(view.getContext(),ListaEstudiantesActivity.class);
                startActivity(anterior);
            }
        });
    }
}