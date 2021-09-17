package com.jacob.educamep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jacob.educamep.clasesLogicas.BDEducaMep;
import com.jacob.educamep.clasesLogicas.Docente;
import com.jacob.educamep.clasesLogicas.Usuario;

public class AgregarNoticiaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agregarnoticia);
        TextView lblNombreCurso = findViewById(R.id.tvCursoActual);
        EditText txtTitulo = findViewById(R.id.tbTitulo);
        EditText txtDescripcion = findViewById(R.id.taDescripcion);
        Button btnPublicar = findViewById(R.id.btnPublicar);
        Button btnAtras = findViewById(R.id.btnAtras);

        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent anterior = new Intent(view.getContext(),DocentePrincipalActivity.class);
                startActivity(anterior);
            }
        });

        String id = (String) getIntent().getSerializableExtra("idCurso");
        Log.d("mi appaaaaaaa",id);
        lblNombreCurso.setText(id);
        btnPublicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Docente usuario = (Docente) getIntent().getSerializableExtra("usuario");
                BDEducaMep db = new BDEducaMep(view.getContext(), (Usuario) usuario, 1, 1);
                int intId = Integer.parseInt(id);
                String titulo = txtTitulo.getText().toString();
                String descripcion = txtDescripcion.getText().toString();

                db.execute(intId, titulo, descripcion);
                Intent anterior = new Intent(view.getContext(),DocentePrincipalActivity.class);
                startActivity(anterior);
            }
        });
    }
}