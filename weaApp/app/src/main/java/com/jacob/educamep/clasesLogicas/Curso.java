package com.jacob.educamep.clasesLogicas;

import java.util.ArrayList;

public class Curso {
    public int idCurso;
    public String nombre;
    public int grado;
    public ArrayList<Horario> horarios = new ArrayList<>();
    public ArrayList<Estudiante> listaEstudiantes = new ArrayList<>();
    public Docente profesorEncargado;
    public ArrayList<Noticia> listaNoticias = new ArrayList<>();
    public ArrayList<Tarea> listaTareas = new ArrayList<>();

    public Curso(int idCurso, String nombre, int grado,
                 ArrayList<Horario> horarios, ArrayList<Estudiante> listaEstudiantes,
                 Docente profesorEncargado, ArrayList<Noticia> listaNoticias, ArrayList<Tarea> listaTareas) {
        this.idCurso = idCurso;
        this.nombre = nombre;
        this.grado = grado;
        this.horarios = horarios;
        this.listaEstudiantes = listaEstudiantes;
        this.profesorEncargado = profesorEncargado;
        this.listaNoticias = listaNoticias;
        this.listaTareas = listaTareas;
    }
    public boolean determinarChoqueHorario(){
        return true;
    }
}
