package com.jacob.educamep;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

import com.jacob.educamep.clasesLogicas.BDEducaMep;
import com.jacob.educamep.clasesLogicas.Docente;
import com.jacob.educamep.clasesLogicas.Usuario;

import java.util.Calendar;

public class AgregarTareaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agregartarea);
        TextView lblNombreCurso = findViewById(R.id.tvCursoActual);
        EditText txtTitulo = findViewById(R.id.tbTitulo);
        TextView txtFecha = findViewById(R.id.tbTitulo3);
        EditText txtDescripcion = findViewById(R.id.taDescripcion);
        Button btnCalendario = findViewById(R.id.btnCalendar);
        Button btnPublicar = findViewById(R.id.btnPublicar);
        Button btnAtras = findViewById(R.id.btnAtras);
        CalendarView calendar = findViewById(R.id.calendarView);
        calendar.setVisibility(View.INVISIBLE);

        String id = (String) getIntent().getSerializableExtra("idCurso");
        lblNombreCurso.setText(id);

        btnCalendario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (calendar.getVisibility()==View.VISIBLE) {
                    calendar.setVisibility(View.INVISIBLE);
                    btnCalendario.setVisibility(View.VISIBLE);
                }else{
                    calendar.setVisibility(View.VISIBLE);
                    btnCalendario.setVisibility(View.INVISIBLE);
                }
            }
        });

        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {
                String fecha = year + "-" + month + "-" + day;
                txtFecha.setText(fecha);
                calendar.setVisibility(View.INVISIBLE);
                btnCalendario.setVisibility(View.VISIBLE);
            }
        });

        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent anterior = new Intent(view.getContext(), DocentePrincipalActivity.class);
                startActivity(anterior);
            }
        });

        btnPublicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Docente usuario = (Docente) getIntent().getSerializableExtra("usuario");
                BDEducaMep db = new BDEducaMep(view.getContext(), (Usuario) usuario, 2, 1);
                int intId = Integer.parseInt(id);
                String titulo = txtTitulo.getText().toString();
                String fecha = txtFecha.getText().toString();
                String descripcion = txtDescripcion.getText().toString();

                db.execute(intId, titulo, fecha, descripcion);
                Intent anterior = new Intent(view.getContext(),DocentePrincipalActivity.class);
                startActivity(anterior);
            }
        });
    }
}