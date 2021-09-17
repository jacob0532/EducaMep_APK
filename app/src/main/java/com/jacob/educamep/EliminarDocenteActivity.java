package com.jacob.educamep;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TextView;

import com.jacob.educamep.clasesLogicas.Administrador;
import com.jacob.educamep.clasesLogicas.BDEducaMep;
import com.jacob.educamep.clasesLogicas.Usuario;

import java.util.ArrayList;

public class EliminarDocenteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eliminardocente);
        final Spinner comboBoxCedulas = findViewById(R.id.sCedulas);
        final TextView lblNombre = findViewById(R.id.tvNombre);
        final TextView lblPrimerApellido = findViewById(R.id.tvPrimerApellido);
        final TextView lblSegundoApellido = findViewById(R.id.tvSegundoApellido);
        final TextView lblCorreo = findViewById(R.id.tvCorreo);
        final TextView lblCalificacionPromedio = findViewById(R.id.tvCalificacion);
        final TableLayout tblCursos = findViewById(R.id.tableCursos);
        final Button btnEliminar = findViewById(R.id.btnEliminar);
        final Button btnAtras = findViewById(R.id.btnAtras);

        ArrayList<String[]> docentes = (ArrayList<String[]>) getIntent().getSerializableExtra("docentes");//docentes
        ArrayList<String> cedulas = new ArrayList<>();

        for (int i=0; i< docentes.size(); i++){
            cedulas.add(String.valueOf(docentes.get(i)[0]));
        }
        ArrayAdapter<CharSequence> adapter=new ArrayAdapter(this, android.R.layout.simple_spinner_item,cedulas);
        comboBoxCedulas.setAdapter(adapter);

        comboBoxCedulas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String text = comboBoxCedulas.getSelectedItem().toString();

                lblNombre.setText(docentes.get(position)[1].toString());
                lblPrimerApellido.setText(docentes.get(position)[2].toString());
                lblSegundoApellido.setText(docentes.get(position)[3].toString());
                lblCorreo.setText(docentes.get(position)[4].toString());
                //lblCalificacionPromedio.setText(docentes.get(position)[5].toString());
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
                BDEducaMep db = new BDEducaMep(EliminarDocenteActivity.this, (Usuario) usuario, 2, 4);

                Long idcedula= Long.valueOf(comboBoxCedulas.getSelectedItem().toString());

                db.execute(idcedula);
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
