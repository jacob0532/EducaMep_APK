package com.jacob.educamep.clasesLogicas;

import java.util.ArrayList;

public class Docente extends Usuario{
    float calificacionPromedio;
    ArrayList<Curso> listaCursos = new ArrayList<>();

    public Docente(long cedula, String nombre, String apellido1, String apellido2, String correoElectronico, String contraseña, float calificacionPromedio, ArrayList<Curso> listaCursos) {
        super(cedula, nombre, apellido1, apellido2, correoElectronico, contraseña);
        this.calificacionPromedio = calificacionPromedio;
        this.listaCursos = listaCursos;
    }
    public void agregarNoticias(int idCurso){

    }
    public void agregarTareas(int idCurso){

    }
    public void visualizarEstudiantes(int idCurso){

    }
    public void enviarMensaje(String mensaje){

    }
}
