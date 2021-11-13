package com.jacob.educamep.clasesLogicas;

import java.util.Date;

public class Tarea {
    int idTarea;
    String titulo;
    String descripcion;
    Date fechaAsignada;
    Date fechaEntrega;

    public Tarea(int idTarea, String titulo, String descripcion, Date fechaAsignada, Date fechaEntrega) {
        this.idTarea = idTarea;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaAsignada = fechaAsignada;
        this.fechaEntrega = fechaEntrega;
    }
    public void realizarRecordatorio(){

    }
}
