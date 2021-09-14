package com.jacob.educamep;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

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
    }
}