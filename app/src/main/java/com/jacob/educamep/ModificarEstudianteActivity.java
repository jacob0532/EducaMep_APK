package com.jacob.educamep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableLayout;

import com.jacob.educamep.clasesLogicas.Administrador;
import com.jacob.educamep.clasesLogicas.BDEducaMep;

import java.util.ArrayList;

public class ModificarEstudianteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modificarestudiante);
        //--------------------------------------------------------------------
        final EditText txtNombre = findViewById(R.id.tbNombre);
        final EditText txtPrimerApellido = findViewById(R.id.tbPrimerApellido);
        final EditText txtSegundoApellido = findViewById(R.id.tbSegundoApellido);
        final EditText txtCorreo = findViewById(R.id.tbCorreo);
        //-------------------------------------------------------
        final Spinner comboBoxCedulasEst = findViewById(R.id.sCedulas);
        final Spinner comboBoxGradoEsc = findViewById(R.id.sGrado);
        final Spinner comboBoxCursos = findViewById(R.id.sCursos);
        final TableLayout tablaCursos = findViewById(R.id.tableCursos);
        //-------------------------------------------------------
        final Button btnEliminarCurso = findViewById(R.id.btnEliminarsCurso);
        final Button btnAgregarCurso = findViewById(R.id.btnAgregarCurso);
        final Button btnAtras = findViewById(R.id.btnAtras);
        final Button btnConfirmar = findViewById(R.id.btnConfirmar);

        Administrador usuario = new Administrador(1, "admin", "_", "_", "admin@gmail.com", "superpepito");

        BDEducaMep db = new BDEducaMep(ModificarEstudianteActivity.this, usuario, 3, 3);


        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.gradosSpinner, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        comboBoxGradoEsc.setAdapter(adapter2);

        ArrayList<String[]> estudiantes = (ArrayList<String[]>) getIntent().getSerializableExtra("estudiantes");//Estudiantes
        ArrayList<String> cedulas = new ArrayList<>();

        for (int i=0; i< estudiantes.size(); i++){
            cedulas.add(String.valueOf(estudiantes.get(i)[0]));
        }
        ArrayAdapter<CharSequence> adapter=new ArrayAdapter(this, android.R.layout.simple_spinner_item,cedulas);
        comboBoxCedulasEst.setAdapter(adapter);

        comboBoxCedulasEst.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String text = comboBoxCedulasEst.getSelectedItem().toString();

                txtNombre.setText(estudiantes.get(position)[1].toString());
                txtPrimerApellido.setText(estudiantes.get(position)[2].toString());
                txtSegundoApellido.setText(estudiantes.get(position)[3].toString());
                txtCorreo.setText(estudiantes.get(position)[4].toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });


        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Long cedula= Long.valueOf(comboBoxCedulasEst.getSelectedItem().toString());
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
