package com.jacob.educamep;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.jacob.educamep.clasesLogicas.Administrador;
import com.jacob.educamep.clasesLogicas.BDEducaMep;
import com.jacob.educamep.clasesLogicas.Docente;
import com.jacob.educamep.clasesLogicas.Estudiante;
import com.jacob.educamep.clasesLogicas.Usuario;

import java.io.Serializable;
import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {
    int tipoUsuario; //1 admi, 2 docente, 3 estudiante

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        tipoUsuario = getIntent().getIntExtra("tipoUsuario",0); //retorna 1,2 o 3
        //Log.d("MI APP REVISAR",String.valueOf(tipoUsuario));
        final EditText txtUsuario =  findViewById(R.id.tbUsuario);
        final EditText txtContraseña = findViewById(R.id.tbContrasena);
        final Button btnIniciar = findViewById(R.id.btnIniciar);
        Usuario usuario = new Usuario(0, null,null, null,txtUsuario.getText().toString(),null);
        BDEducaMep bd = new BDEducaMep(LoginActivity.this,usuario,0,0);
        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bd.execute(tipoUsuario);
                Log.d("prueba",String.valueOf(bd.valorEntrada));
                if(true){
                    Intent siguiente = null;
                    switch (tipoUsuario){
                        case 1:
                            siguiente =
                                    new Intent(v.getContext(),AdministradorPrincipalActivity.class);
                            break;
                        case 2:
                            siguiente =
                                    new Intent(v.getContext(),DocentePrincipalActivity.class);
                            break;
                        case 3:
                            siguiente =
                                    new Intent(v.getContext(),EstudiantePrincipalActivity.class);
                            break;
                    }

                    Bundle b = new Bundle();
                    b.putSerializable("usuario", (Serializable) usuario);
                    siguiente.putExtras(b);
                    startActivity(siguiente);
                }

            }
        });
    }
}
