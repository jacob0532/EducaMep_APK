package com.jacob.educamep.clasesLogicas;


import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.io.Serializable;



public class Usuario implements Serializable{
    public long cedula;
    public String nombre;
    public String apellido1;
    public String apellido2;
    public String correoElectronico;
    public String contraseña;
    StringParser parser = new StringParser();
    public Usuario(long cedula, String nombre, String apellido1, String apellido2,
                   String correoElectronico, String contraseña) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.correoElectronico = correoElectronico;
        this.contraseña = contraseña;
    }
    public boolean iniciarSesion(int tipo){
        boolean res = false;
        String registrar_url = null;
        switch (tipo){
            case 1:
                registrar_url = "http://educamep.freeoda.com/scriptsEducaMep/Administrador/";
                break;
            case 2:
                registrar_url = "http://educamep.freeoda.com/scriptsEducaMep/Administrador/mostrarDocentes.php";
                break;
            case 3:
                registrar_url = "http://educamep.freeoda.com/scriptsEducaMep/Administrador/mostrarEstudiante.php";
                break;
        }
        ArrayList<String[]> list = new ArrayList<String[]>();
        try {
            Log.d("a ver",registrar_url);
            URL url = new URL(registrar_url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            StringBuilder stringBuilder = new StringBuilder();

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                Log.d("MI OPPPOPOPO", line);
                stringBuilder.append(line);
            }
            String temp = stringBuilder.toString();
            list = parser.convert(temp);

            bufferedReader.close();
            inputStream.close();
            httpURLConnection.disconnect();
            res = iniciarSesio2(list);
        } catch (MalformedURLException e) {
            Log.d("MI APP","SE HA UTILIZADO UNA URL CON FORMATO INCORRECTO");
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            Log.d("MI APP","Error, CONECTESE A INTERNET >:/");
            return false;
        }
        return res;
    }
    public boolean iniciarSesio2(ArrayList<String[]> list){
        for (int i=0;i<list.size();i++){
            if(this.correoElectronico.equals(list.get(i)[4]) && this.cedula == Long.parseLong(list.get(i)[0])){
                this.cedula = Long.parseLong(list.get(i)[0]);
                this.nombre = list.get(i)[1];
                this.apellido1 = list.get(i)[2];
                this.apellido2 = list.get(i)[3];
                this.correoElectronico = list.get(i)[4];
                this.contraseña = null;
                return true;
            }
        }
        return false;
    }
}
