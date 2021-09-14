package com.jacob.educamep.clasesLogicas;

enum Dia{
    Lunes,
    Martes,
    Miercoles,
    Jueves,
    Viernes,
    Sabado,
    Domingo
}
public class Horario {
    String horaInicial;
    String horaFinal;
    Dia dia;

    public Horario(String horaInicial, String horaFinal, Dia dia) {
        this.horaInicial = horaInicial;
        this.horaFinal = horaFinal;
        this.dia = dia;
    }
}
