package com.jacob.educamep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.jacob.educamep.clasesLogicas.Administrador;
import com.jacob.educamep.clasesLogicas.BDEducaMep;

import java.util.ArrayList;

public class GestionCursosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gestioncursos);
        final Button btnAgregar = findViewById(R.id.btnAgregar);
        final Button btnEliminar = findViewById(R.id.btnEliminar);
        final Button btnModificar = findViewById(R.id.btnModificar);
        final Button btnAtras = findViewById(R.id.btnAtras);
        Administrador a = new Administrador(0,null,null,null,null,null);
        BDEducaMep bd = new BDEducaMep(GestionCursosActivity.this,a,0,0);
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent siguiente = new Intent(v.getContext(),AgregarCursoActivity.class);
                startActivity(siguiente);
            }
        });
        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bd.accion1 = 1;
                bd.accion2 = 2;
                bd.execute();
                while(bd.resultado2 == null){
                    Log.d("MI OPPPOPOPO", "loading...");
                }
                Intent siguiente = new Intent(v.getContext(),EliminarCursoActivity.class);
                Bundle b = new Bundle();
                b.putSerializable("list", (ArrayList<String[]>)bd.resultado2);
                siguiente.putExtras(b);
                startActivity(siguiente);
            }
        });
        btnModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bd.accion1 = 1;
                bd.accion2 = 2;
                bd.execute();
                while(bd.resultado2 == null){
                    Log.d("MI OPPPOPOPO", "loading...");
                }
                Intent siguiente = new Intent(v.getContext(),ModificarCursoActivity.class);
                Bundle b = new Bundle();
                b.putSerializable("list", (ArrayList<String[]>)bd.resultado2);
                siguiente.putExtras(b);
                startActivity(siguiente);
            }
        });
        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent atras = new Intent(v.getContext(),AdministradorPrincipalActivity.class);
                startActivity(atras);
            }
        });
    }
}