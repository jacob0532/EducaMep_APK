package com.jacob.educamep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableLayout;

import com.jacob.educamep.clasesLogicas.Administrador;
import com.jacob.educamep.clasesLogicas.BDEducaMep;
import com.jacob.educamep.clasesLogicas.Usuario;

public class AgregarDocenteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agregardocente);
        //--------------------------------------------------------------------
        final EditText txtCedula = findViewById(R.id.tbCedula);
        final EditText txtNombre = findViewById(R.id.tbNombre);
        final EditText txtPrimerApellido = findViewById(R.id.tbPrimerApellido);
        final EditText txtSegundoApellido = findViewById(R.id.tbSegundoApellido);
        final EditText txtCorreo = findViewById(R.id.tbCorreo);
        //-------------------------------------------------------
        final Spinner comboBoxCursos = findViewById(R.id.sCursos);
        final TableLayout tablaCursos = findViewById(R.id.tableCursos);
        //-------------------------------------------------------
        final Button btnEliminarCurso = findViewById(R.id.btnEliminarsCurso);
        final Button btnAgregarCurso = findViewById(R.id.btnAgregarCurso);
        final Button btnAtras = findViewById(R.id.btnAtras);
        final Button btnConfirmar = findViewById(R.id.btnConfirmar);
        //-------------------------------------------------------
        //to-do eliminar pruebas
        Administrador usuario = new Administrador(123456, "pepito", "Ramirez", "Mora", "pepito@gmail.com", "superpepito");
        //BDEducaMep db = new BDEducaMep(AgregarDocenteActivity.this, (Usuario) usuario, 2, 1);
        BDEducaMep db = new BDEducaMep(AgregarDocenteActivity.this,usuario , 2, 1);
        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long cedula = Long.parseLong(txtCedula.getText().toString());
                String nombre = txtNombre.getText().toString();
                String apellido1 = txtPrimerApellido.getText().toString();
                String apellido2 = txtSegundoApellido.getText().toString();
                String correo = txtSegundoApellido.getText().toString();
                db.execute(cedula, nombre, apellido1, apellido2, correo);

                Intent anterior = new Intent(view.getContext(),GestionDocentesActivity.class);
                startActivity(anterior);
            }
        });
        
        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent anterior = new Intent(view.getContext(),GestionDocentesActivity.class);
                startActivity(anterior);
            }
        });
    }
}
