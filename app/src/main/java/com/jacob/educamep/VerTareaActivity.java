package com.jacob.educamep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class VerTareaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vertarea);
        final TextView lblNombreCurso = findViewById(R.id.tvCursoActual);
        final TextView lblTituloTarea = findViewById(R.id.tvTitulo2);
        final TextView containerDescripcion = findViewById(R.id.tvDescripcion2);
        final Button btnNotificar = findViewById(R.id.button);
        final Button btnAtras = findViewById(R.id.btnAtras);

        String id = (String) getIntent().getSerializableExtra("idCurso");
        lblNombreCurso.setText(id);
        String titulo = (String) getIntent().getSerializableExtra("titulo");
        lblTituloTarea.setText(titulo);
        String descripcion = (String) getIntent().getSerializableExtra("descripcion");
        containerDescripcion.setText(descripcion);

        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent anterior = new Intent(view.getContext(),ListaTareasActivity.class);
                startActivity(anterior);
            }
        });
    }
}