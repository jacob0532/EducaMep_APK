package com.jacob.educamep.clasesLogicas;

import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;


public class Estudiante extends Usuario implements Serializable {
    String gradoEscolar;
    ArrayList<Curso> listaCursos = new ArrayList<Curso>();
    StringParser parser = new StringParser();

    public Estudiante(long cedula, String nombre, String apellido1, String apellido2,
                      String correoElectronico, String contraseña, String gradoEscolar,
                      ArrayList<Curso> listaCursos) {
        super(cedula, nombre, apellido1, apellido2, correoElectronico, contraseña);
        this.gradoEscolar = gradoEscolar;
        this.listaCursos = listaCursos;
    }

    public returnAsync visualizarListaNoticias(int idCurso){
        ArrayList<String[]> list = new ArrayList<String[]>();
        String registrar_url = "http://educamep.freeoda.com/scriptsEducaMep/Estudiante/visualizarNoticias.php";
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
                Log.d("MI OPPPOPOPO", line);
                stringBuilder.append(line);
            }
            String temp = stringBuilder.toString();
            list = parser.convert(temp);

            bufferedReader.close();
            inputStream.close();
            httpURLConnection.disconnect();

        } catch (MalformedURLException e) {
            Log.d("MI APP","SE HA UTILIZADO UNA URL CON FORMATO INCORRECTO");
            return new returnAsync("SE HA PRODUCIDO UN ERROR CATCH1", null);
        } catch (IOException e) {
            e.printStackTrace();
            Log.d("MI APP","Error, CONECTESE A INTERNET >:/");
            return new returnAsync("Se ha producido un error, comprueba tu conexión a internet", null);
        }
        return new returnAsync("funciono", list);
    }

    public void visualizarNoticia(int idCurso){

    }

    public returnAsync visualizarListaTareas(int idCurso){
        ArrayList<String[]> list = new ArrayList<String[]>();
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
                Log.d("MI OPPPOPOPO", line);
                stringBuilder.append(line);
            }
            String temp = stringBuilder.toString();
            list = parser.convert(temp);

            bufferedReader.close();
            inputStream.close();
            httpURLConnection.disconnect();

        } catch (MalformedURLException e) {
            Log.d("MI APP","SE HA UTILIZADO UNA URL CON FORMATO INCORRECTO");
            return new returnAsync("SE HA PRODUCIDO UN ERROR CATCH1", null);
        } catch (IOException e) {
            e.printStackTrace();
            Log.d("MI APP","Error, CONECTESE A INTERNET >:/");
            return new returnAsync("Se ha producido un error, comprueba tu conexión a internet", null);
        }
        return new returnAsync("funciono", list);
    }

    public void visualizarTarea(int idCurso){

    }
    public returnAsync visualizarProfesor(int idCurso){
        ArrayList<String[]> list = new ArrayList<String[]>();
        String registrar_url = "http://educamep.freeoda.com/scriptsEducaMep/Estudiante/visualizarDocente.php";
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
                Log.d("MI OPPPOPOPO", line);
                stringBuilder.append(line);
            }
            String temp = stringBuilder.toString();
            list = parser.convert(temp);

            bufferedReader.close();
            inputStream.close();
            httpURLConnection.disconnect();

        } catch (MalformedURLException e) {
            Log.d("MI APP","SE HA UTILIZADO UNA URL CON FORMATO INCORRECTO");
            return new returnAsync("SE HA PRODUCIDO UN ERROR CATCH1", null);
        } catch (IOException e) {
            e.printStackTrace();
            Log.d("MI APP","Error, CONECTESE A INTERNET >:/");
            return new returnAsync("Se ha producido un error, comprueba tu conexión a internet", null);
        }
        return new returnAsync("funciono", list);
    }
    public void enviarMensaje(String mensaje){

    }
    public void calificarProfesor(int idCurso){

    }
}
