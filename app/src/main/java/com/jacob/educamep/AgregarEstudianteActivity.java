package com.jacob.educamep;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TextView;

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
        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long cedula = Integer.parseInt(txtCedula.getText().toString());
                String nombre = txtNombre.getText().toString();
                String apellido1 = txtPrimerApellido.getText().toString();
                String apellido2 = txtSegundoApellido.getText().toString();
                String correo = txtCorreo.getText().toString();
                String grado= "No aplica";//hay que obtenerlo del "combobox" de los grados que deben de estar predefinidos.
                db.execute(cedula, nombre, apellido1, apellido2, correo,grado);

                Intent anterior = new Intent(view.getContext(),GestionDocentesActivity.class);
                startActivity(anterior);
            }
        });
        
    }
}
