package com.jacob.educamep.clasesLogicas;

import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Estudiante extends Usuario{
    int gradoEscolar;
    ArrayList<Curso> listaCursos = new ArrayList<Curso>();
    ArrayList<Tarea> tareaCurso = new ArrayList<>();

    public Estudiante(long cedula, String nombre, String apellido1, String apellido2,
                      String correoElectronico, String contraseña, int gradoEscolar,
                      ArrayList<Curso> listaCursos) {
        super(cedula, nombre, apellido1, apellido2, correoElectronico, contraseña);
        this.gradoEscolar = gradoEscolar;
        this.listaCursos = listaCursos;
    }

    public void visualizarListaNoticias(int idCurso){

    }

    public void visualizarNoticia(int idCurso){

    }

    public String visualizarListaTareas(int idCurso){
        tareaCurso = new ArrayList<>();
        String registrar_url = "http://educamep.freeoda.com/scriptsEducaMep/Estudiante/visualizarTareas.php";
        try {
            URL url = new URL(registrar_url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);

            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));
            String data = URLEncoder.encode("idCurso","UTF-8") + "=" + URLEncoder.encode(String.valueOf(idCurso),"UTF-8");

            bufferedWriter.write(data);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();

            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            StringBuilder stringBuilder = new StringBuilder();

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                Log.d("MI APPPAPAPA", line);
                stringBuilder.append(line);
            }
            String temp = stringBuilder.toString();

            Log.d("MI APPPAPAPA", "================================");
            Log.d("MI APPPAPAPA", temp);
            Log.d("MI APPPAPAPA", "================================");
            bufferedReader.close();
            inputStream.close();
            httpURLConnection.disconnect();

        } catch (MalformedURLException e) {
            Log.d("MI APP","SE HA UTILIZADO UNA URL CON FORMATO INCORRECTO");
            return "SE HA PRODUCIDO UN ERROR CATCH1";
        } catch (IOException e) {
            e.printStackTrace();
            Log.d("MI APP","Error, CONECTESE A INTERNET >:/");
            return "Se ha producido un error, comprueba tu conexión a internet";
        }
        return "funciono";
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
