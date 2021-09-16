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

public class Docente extends Usuario{
    float calificacionPromedio;
    ArrayList<Curso> listaCursos = new ArrayList<>();
    StringParser parser = new StringParser();

    public Docente(long cedula, String nombre, String apellido1, String apellido2, String correoElectronico, String contraseña, float calificacionPromedio, ArrayList<Curso> listaCursos) {
        super(cedula, nombre, apellido1, apellido2, correoElectronico, contraseña);
        this.calificacionPromedio = calificacionPromedio;
        this.listaCursos = listaCursos;
    }
    public String agregarNoticias(int idCurso, String titulo, String descripcion){
        String registrar_url = "http://educamep.freeoda.com/scriptsEducaMep/Docente/crearNoticia.php";
        try {
            Log.d("MI APP","Inicia....");
            URL url = new URL(registrar_url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));
            String data = URLEncoder.encode("idCurso","UTF-8") + "=" + URLEncoder.encode(String.valueOf(idCurso),"UTF-8") + "&" +
                    URLEncoder.encode("titulo","UTF-8") + "=" + URLEncoder.encode(titulo,"UTF-8") + "&" +
                    URLEncoder.encode("texto","UTF-8") + "=" + URLEncoder.encode(descripcion,"UTF-8");

            bufferedWriter.write(data);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();

            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,StandardCharsets.UTF_8));
            StringBuilder stringBuilder = new StringBuilder();

            String line;
            while ((line = bufferedReader.readLine()) != null){
                stringBuilder.append(line);

            }
            bufferedReader.close();
            inputStream.close();
            httpURLConnection.disconnect();
            Log.d("MI APP","Termino....");
            return stringBuilder.toString();

        } catch (MalformedURLException e) {
            Log.d("MI APP","SE HA UTILIZADO UNA URL CON FORMATO INCORRECTO");
            return "SE HA PRODUCIDO UN ERROR CATCH1";
        } catch (IOException e) {
            e.printStackTrace();
            Log.d("MI APP","Error, CONECTESE A INTERNET >:/");
            return "Se ha producido un error, comprueba tu conexión a internet";
        }
    }

    public void agregarTareas(int idCurso){

    }

    public returnAsync visualizarListaEstudiantes(int idCurso){
        ArrayList<String[]> list = new ArrayList<String[]>();
        String registrar_url = "http://educamep.freeoda.com/scriptsEducaMep/Docente/visualizarEstudiantes.php";
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

    public void visualizarEstudiantes(int idCurso){

    }
    public void enviarMensaje(String mensaje){

    }
}
