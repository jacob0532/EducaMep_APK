package com.jacob.educamep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class PerfilDocenteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.perfildocente);
        final TextView lblNombreCurso = findViewById(R.id.tvCursoActual);
        final TextView lblCedula = findViewById(R.id.tvCarnet2);
        final TextView lblNombreDocente = findViewById(R.id.tvNombre2);
        final TextView lblCorreo = findViewById(R.id.tvCorreo2);
        final TextView lblCalificacionPromedio = findViewById(R.id.tvCalificacionPromedio2);

        final Button btnEstrella1 = findViewById(R.id.btnStar1);
        final Button btnEstrella2 = findViewById(R.id.btnStar2);
        final Button btnEstrella3 = findViewById(R.id.btnStar3);
        final Button btnEstrella4 = findViewById(R.id.btnStar4);
        final Button btnEstrella5 = findViewById(R.id.btnStar5);
        final Button btnAtras = findViewById(R.id.btnAtras);

        ArrayList<String[]> profesor = (ArrayList<String[]>) getIntent().getSerializableExtra("profesor");
        String id = (String) getIntent().getSerializableExtra("idCurso");
        lblNombreCurso.setText(id);
        String cedula = profesor.get(0)[0];
        lblCedula.setText(cedula);
        String nombre = profesor.get(0)[1] + profesor.get(0)[2] + profesor.get(0)[3];
        lblNombreDocente.setText(nombre);
        String correo = profesor.get(0)[4];
        lblCorreo.setText(correo);

        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent anterior = new Intent(view.getContext(),EstudiantePrincipalActivity.class);
                startActivity(anterior);
            }
        });
    }
}