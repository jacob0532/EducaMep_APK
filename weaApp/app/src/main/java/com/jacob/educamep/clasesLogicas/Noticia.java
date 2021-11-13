package com.jacob.educamep.clasesLogicas;

import java.util.ArrayList;
import java.util.Date;

public class Noticia {
    int idNoticia;
    String titulo;
    String texto;
    Date fecha;

    public Noticia(int idNoticia, String titulo, String texto, Date fecha) {
        this.idNoticia = idNoticia;
        this.titulo = titulo;
        this.texto = texto;
        this.fecha = fecha;
    }
}
