package com.jacob.educamep;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

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
    }
}
