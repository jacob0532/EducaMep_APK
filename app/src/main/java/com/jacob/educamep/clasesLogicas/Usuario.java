package com.jacob.educamep.clasesLogicas;

import java.io.Serializable;

public class Usuario implements Serializable {
    long cedula;
    String nombre;
    String apellido1;
    String apellido2;
    String correoElectronico;
    String contraseña;

    public Usuario(long cedula, String nombre, String apellido1, String apellido2,
                   String correoElectronico, String contraseña) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.correoElectronico = correoElectronico;
        this.contraseña = contraseña;
    }
    public boolean iniciarSesion(){
        return true;
    }
}
