package com.jacob.educamep.clasesLogicas;

import java.util.ArrayList;

public class Estudiante extends Usuario{
    int gradoEscolar;
    ArrayList<Curso> listaCursos = new ArrayList<Curso>();

    public Estudiante(long cedula, String nombre, String apellido1, String apellido2,
                      String correoElectronico, String contraseña, int gradoEscolar,
                      ArrayList<Curso> listaCursos) {
        super(cedula, nombre, apellido1, apellido2, correoElectronico, contraseña);
        this.gradoEscolar = gradoEscolar;
        this.listaCursos = listaCursos;
    }
    public void visualizarNoticia(int idCurso){

    }
    public void visualizarTarea(int idCurso){

    }
    public void visualizarProfesor(int idCurso){

    }
    public void enviarMensaje(String mensaje){

    }
    public void calificarProfesor(int idCurso){

    }

}
