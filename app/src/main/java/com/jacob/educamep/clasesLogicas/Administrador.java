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


public class Administrador extends Usuario implements Serializable {
    StringParser parser = new StringParser();
    public Administrador(long cedula, String nombre, String apellido1, String apellido2, String correoElectronico, String contraseña) {
        super(cedula, nombre, apellido1, apellido2, correoElectronico, contraseña);
    }

    /*
    **********************
    * Funciones de curso *
    * *********************
     */
    public String insertarCurso(String nombre, String grado, ArrayList<Horario> horarios){
        String registrar_url = "http://educamep.freeoda.com/scriptsEducaMep/Administrador/InsertarCurso.php";
        try {
            Log.d("MI APP","Inicia....");
            URL url = new URL(registrar_url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter
                    (new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));
            String data =
                    URLEncoder.encode("nombre","UTF-8") +
                            "=" + URLEncoder.encode(nombre,"UTF-8") + "&" +
                    URLEncoder.encode("grado","UTF-8") +
                            "=" + URLEncoder.encode(grado,"UTF-8");

            bufferedWriter.write(data);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();

            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader
                    (new InputStreamReader(inputStream,StandardCharsets.UTF_8));
            StringBuilder stringBuilder = new StringBuilder();

            String line;
            while ((line = bufferedReader.readLine()) != null){
                stringBuilder.append(line);
            }
            bufferedReader.close();
            inputStream.close();
            httpURLConnection.disconnect();
            Log.d("MI APP","Termino....");
            crearHorario(horarios);//AGREGA LOS HORARIOS A ESE CURSO
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
    //"SELECT max(idCurso) FROM Curso"
    public void crearHorario(ArrayList<Horario> horarios){
        String registrar_url = "http://educamep.freeoda.com/scriptsEducaMep/Administrador/crearHorario.php";
        try {
            Log.d("MI APP","Inicia....");
            URL url = new URL(registrar_url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter
                    (new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));
            String data;
            for (int i = 0;i<horarios.size();i++){
                data =
                        URLEncoder.encode("dia","UTF-8") +
                                "=" + URLEncoder.encode(horarios.get(i).dia,"UTF-8") + "&" +
                                URLEncoder.encode("horaInicio","UTF-8") +
                                "=" + URLEncoder.encode(horarios.get(i).horaInicial,"UTF-8") + "&" +
                                URLEncoder.encode("horaFinal","UTF-8") +
                                "=" + URLEncoder.encode(horarios.get(i).horaFinal,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
            }
            bufferedWriter.close();
            outputStream.close();

            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader
                    (new InputStreamReader(inputStream,StandardCharsets.UTF_8));
            StringBuilder stringBuilder = new StringBuilder();

            String line;
            while ((line = bufferedReader.readLine()) != null){
                stringBuilder.append(line);
            }
            bufferedReader.close();
            inputStream.close();
            httpURLConnection.disconnect();
            Log.d("MI APP","Termino....");
            return ;
        } catch (MalformedURLException e) {
            Log.d("MI APP","SE HA UTILIZADO UNA URL CON FORMATO INCORRECTO");
            return ;
        } catch (IOException e) {
            e.printStackTrace();
            Log.d("MI APP","Error, CONECTESE A INTERNET >:/");
            return ;
        }

    }
    public void modificarCurso(){

    }
    public void eliminarCurso(){

    }
    public returnAsync mostrarIdsCurso(){
        ArrayList<String[]> list = new ArrayList<String[]>();
        String registrar_url = "http://educamep.freeoda.com/scriptsEducaMep/Administrador/mostrarCursos.php";
        try {
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
    public void asignarDocenteCurso(){

    }
    public void asignarEstudianteCurso(){

    }
    /*
     ***************************
     * Funciones de estudiante *
     * *************************
     */
    public String insertarEstudiante(long cedula, String nombre, String apellido1, String apellido2, String correo, String grado){
        String registrar_url = "http://educamep.freeoda.com/scriptsEducaMep/Administrador/insertarEstudiante.php";
        try {
            Log.d("MI APP","Inicia....");
            URL url = new URL(registrar_url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));
            String data = URLEncoder.encode("cedula","UTF-8") + "=" + URLEncoder.encode(String.valueOf(cedula),"UTF-8") + "&" +
                    URLEncoder.encode("nombre","UTF-8") + "=" + URLEncoder.encode(nombre,"UTF-8") + "&" +
                    URLEncoder.encode("apellido1","UTF-8") + "=" + URLEncoder.encode(apellido1,"UTF-8") + "&" +
                    URLEncoder.encode("apellido2","UTF-8") + "=" + URLEncoder.encode(apellido2,"UTF-8") + "&" +
                    URLEncoder.encode("correo","UTF-8") + "=" + URLEncoder.encode(correo,"UTF-8") + "&" +
                    URLEncoder.encode("grado","UTF-8") + "=" + URLEncoder.encode(grado,"UTF-8");

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
    
    public String modificarEstudiante(long cedula, String nombre, String apellido1, String apellido2, String correo, String grado){
        String registrar_url = "http://educamep.freeoda.com/scriptsEducaMep/Administrador/actualizarEstudiante.php";
        try {
            Log.d("MI APP","Inicia....");
            URL url = new URL(registrar_url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));
            String data = URLEncoder.encode("cedula","UTF-8") + "=" + URLEncoder.encode(String.valueOf(cedula),"UTF-8") + "&" +
                    URLEncoder.encode("nombre","UTF-8") + "=" + URLEncoder.encode(nombre,"UTF-8") + "&" +
                    URLEncoder.encode("apellido1","UTF-8") + "=" + URLEncoder.encode(apellido1,"UTF-8") + "&" +
                    URLEncoder.encode("apellido2","UTF-8") + "=" + URLEncoder.encode(apellido2,"UTF-8") + "&" +
                    URLEncoder.encode("correo","UTF-8") + "=" + URLEncoder.encode(correo,"UTF-8") + "&" +
                    URLEncoder.encode("grado","UTF-8") + "=" + URLEncoder.encode(grado,"UTF-8");

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

    
    public String eliminarEstudiante(long cedula){
        String registrar_url = "http://educamep.freeoda.com/scriptsEducaMep/Administrador/borrarEstudiante.php";
        try {
            Log.d("MI APP","Inicia....");
            URL url = new URL(registrar_url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));
            String data = URLEncoder.encode("cedula","UTF-8") + "=" + URLEncoder.encode(String.valueOf(cedula),"UTF-8");

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
    
    public returnAsync mostrarEstudiante(){
        ArrayList<String[]> list = new ArrayList<String[]>();
        String registrar_url = "http://educamep.freeoda.com/scriptsEducaMep/Administrador/mostrarEstudiante.php";
        try {
            URL url = new URL(registrar_url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);

            OutputStream outputStream = httpURLConnection.getOutputStream();
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
    
    /*
     ************************
     * Funciones de docente *
     * **********************
     */
    public String insertarDocente(long cedula, String nombre, String apellido1, String apellido2, String correo){
        String registrar_url = "http://educamep.freeoda.com/scriptsEducaMep/Administrador/insertarDocente.php";
        try {
            Log.d("MI APP","Inicia....");
            URL url = new URL(registrar_url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));
            String data = URLEncoder.encode("cedula","UTF-8") + "=" + URLEncoder.encode(String.valueOf(cedula),"UTF-8") + "&" +
                    URLEncoder.encode("nombre","UTF-8") + "=" + URLEncoder.encode(nombre,"UTF-8") + "&" +
                    URLEncoder.encode("apellido1","UTF-8") + "=" + URLEncoder.encode(apellido1,"UTF-8") + "&" +
                    URLEncoder.encode("apellido2","UTF-8") + "=" + URLEncoder.encode(apellido2,"UTF-8") + "&" +
                    URLEncoder.encode("correo","UTF-8") + "=" + URLEncoder.encode(correo,"UTF-8");

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
    public void modificarDocente(){

    }
    public void eliminarDocente(){

    }
    public void mostrarDocente(){

    }



}
