package com.jacob.educamep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jacob.educamep.clasesLogicas.Administrador;
import com.jacob.educamep.clasesLogicas.BDEducaMep;
import com.jacob.educamep.clasesLogicas.Usuario;

import java.util.ArrayList;

public class EliminarEstudianteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eliminarestudiante);
        final Spinner comboBoxCedulas = findViewById(R.id.sCedulas);
        final TextView lblNombre = findViewById(R.id.tvNombre);
        final TextView lblPrimerApellido = findViewById(R.id.tvPrimerApellido);
        final TextView lblSegundoApellido = findViewById(R.id.tvSegundoApellido);
        final TextView lblCorreo = findViewById(R.id.tvCorreo);
        final TextView lblGradoEscolar = findViewById(R.id.tvCalificacion);
        final TableLayout tblCursos = findViewById(R.id.tableCursos);
        final Button btnEliminar = findViewById(R.id.btnEliminar);
        final Button btnAtras = findViewById(R.id.btnAtras);
        
        ArrayList<String[]> estudiantes = (ArrayList<String[]>) getIntent().getSerializableExtra("estudiantes");//Estudiantes
        ArrayList<String> cedulas = new ArrayList<>();

        for (int i=0; i< estudiantes.size(); i++){
            cedulas.add(String.valueOf(estudiantes.get(i)[0]));
        }
        ArrayAdapter<CharSequence> adapter=new ArrayAdapter(this, android.R.layout.simple_spinner_item,cedulas);
        comboBoxCedulas.setAdapter(adapter);

        comboBoxCedulas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String text = comboBoxCedulas.getSelectedItem().toString();

                lblNombre.setText(estudiantes.get(position)[1].toString());
                lblPrimerApellido.setText(estudiantes.get(position)[2].toString());
                lblSegundoApellido.setText(estudiantes.get(position)[3].toString());
                lblCorreo.setText(estudiantes.get(position)[4].toString());
                //lblGradoEscolar.setText(estudiantes.get(position)[5].toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Prueba
                Administrador usuario = new Administrador(123456, "pepito", "Ramirez", "Mora", "pepito@gmail.com", "superpepito");
                BDEducaMep db = new BDEducaMep(EliminarEstudianteActivity.this, (Usuario) usuario, 3, 4);

                Long idcedula= Long.valueOf(comboBoxCedulas.getSelectedItem().toString());

                db.execute(idcedula);

            }
        });
    }
}
