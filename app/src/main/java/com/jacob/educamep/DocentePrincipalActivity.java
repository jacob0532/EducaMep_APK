package com.jacob.educamep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.jacob.educamep.clasesLogicas.BDEducaMep;
import com.jacob.educamep.clasesLogicas.Docente;
import com.jacob.educamep.clasesLogicas.Estudiante;
import com.jacob.educamep.clasesLogicas.Usuario;

import java.util.ArrayList;

public class DocentePrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.docenteprincipal);
        Spinner comboBoxCursos = findViewById(R.id.sCursos);
        Button btnPublicarNoticia = findViewById(R.id.btnNoticia);
        Button btnAsignarTarea = findViewById(R.id.btnTarea);
        Button btnListaEstudiantes = findViewById(R.id.btnLista);
        Button btnChatCurso = findViewById(R.id.btnChat);
        Button btnSalir = findViewById(R.id.btnSalir);

        btnPublicarNoticia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Prueba
                //Docente usuario = new Docente(123456, "pepito", "Ramirez", "Mora", "pepito@gmail.com", "superpepito", 5, null);
                Docente usuario = (Docente) getIntent().getSerializableExtra("usuario");
                Intent send = new Intent(view.getContext(), AgregarNoticiaActivity.class);
                Bundle b = new Bundle();
                b.putSerializable("idCurso", (String) comboBoxCursos.getSelectedItem());
                //b.putSerializable("idCurso", "1");
                b.putSerializable("usuario", usuario);
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
                Docente usuario = (Docente) getIntent().getSerializableExtra("usuario");
                BDEducaMep db = new BDEducaMep(view.getContext(), usuario, 4, 1);
                db.execute((int) getIntent().getSerializableExtra("idCurso"));
                while(db.resultado2 == null){
                    Log.d("MI OPPPOPOPO", "loading...");
                }
                if (db.resultado2.isEmpty()){
                    Toast.makeText(view.getContext(), "no hay estudiantes asignados",Toast.LENGTH_LONG).show();
                }else{
                    Intent send = new Intent(view.getContext(),ListaEstudiantesActivity.class);
                    Bundle b = new Bundle();
                    b.putSerializable("list", (ArrayList<String[]>)db.resultado2);
                    b.putSerializable("idCurso", (String) comboBoxCursos.getSelectedItem());
                    //b.putSerializable("idCurso", "1");
                    send.putExtras(b);
                    startActivity(send);
                }
            }
        });
    }
}