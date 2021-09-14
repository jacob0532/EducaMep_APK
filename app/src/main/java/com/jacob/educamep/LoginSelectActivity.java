package com.jacob.educamep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LoginSelectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginselect);
    }
    public void siguienteAdmiLogin(View view){
        Intent siguiente = new Intent(this,LoginActivity.class);
        siguiente.putExtra("tipoUsuario",1);
        startActivity(siguiente);
    }
    public void siguienteProfLogin(View view){
        Intent siguiente = new Intent(this,LoginActivity.class);
        siguiente.putExtra("tipoUsuario",2);
        startActivity(siguiente);
    }
    public void siguienteEstLogin(View view){
        Intent siguiente = new Intent(this,LoginActivity.class);
        siguiente.putExtra("tipoUsuario",3);
        startActivity(siguiente);
    }

}