package com.jacob.educamep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TextView;

import com.jacob.educamep.clasesLogicas.Administrador;
import com.jacob.educamep.clasesLogicas.BDEducaMep;

public class AgregarEstudianteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agregarestudiante);
        //--------------------------------------------------------------------
        final EditText txtCedula = findViewById(R.id.tbCedula);
        final EditText txtNombre = findViewById(R.id.tbNombre);
        final EditText txtPrimerApellido = findViewById(R.id.tbPrimerApellido);
        final EditText txtSegundoApellido = findViewById(R.id.tbSegundoApellido);
        final EditText txtCorreo = findViewById(R.id.tbCorreo);
        //-------------------------------------------------------
        final Spinner comboBoxGradoEsc = findViewById(R.id.sGrado);
        final Spinner comboBoxCursos = findViewById(R.id.sCursos);
        final TableLayout tablaCursos = findViewById(R.id.tableCursos);
        //-------------------------------------------------------
        final Button btnEliminarCurso = findViewById(R.id.btnEliminarsCurso);
        final Button btnAgregarCurso = findViewById(R.id.btnAgregarCurso);
        final Button btnAtras = findViewById(R.id.btnAtras);
        final Button btnConfirmar = findViewById(R.id.btnConfirmar);
        
        Administrador usuario = new Administrador(1, "admin", "_", "_", "admin@gmail.com", "superpepito");

        BDEducaMep db = new BDEducaMep(AgregarEstudianteActivity.this, usuario, 3, 1);
        
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.gradosSpinner, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        comboBoxGradoEsc.setAdapter(adapter);
        comboBoxGradoEsc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String text = comboBoxGradoEsc.getSelectedItem().toString();
                Log.d("TEXTO del grado",text);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        
        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long cedula = Integer.parseInt(txtCedula.getText().toString());
                String nombre = txtNombre.getText().toString();
                String apellido1 = txtPrimerApellido.getText().toString();
                String apellido2 = txtSegundoApellido.getText().toString();
                String correo = txtCorreo.getText().toString();
                String grado= comboBoxGradoEsc.getSelectedItem().toString();
                db.execute(cedula, nombre, apellido1, apellido2, correo,grado);

                Intent anterior = new Intent(view.getContext(),GestionEstudiantesActivity.class);
                startActivity(anterior);
            }
        });

        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent anterior = new Intent(view.getContext(),GestionEstudiantesActivity.class);
                startActivity(anterior);
            }
        });
        
    }
}
