package com.jacob.educamep.clasesLogicas;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;


//AsynTask: Clase que ejecuta acciones antes, durante o despúes de un suceso
//<Parametros que recibe,info durante el proceso, retorna del proceso>
public class BDEducaMep extends AsyncTask<Object, Void, String> {
    WeakReference<Context> context;
    Usuario autor;
    int accion1;
    int accion2;
    String resultado="";

    public BDEducaMep(Context context, Usuario autor, int accion1, int accion2){
        this.context = new WeakReference<>(context);
        this.autor = autor;
        this.accion1 = accion1;
        this.accion2 = accion2;
    }
    protected String doInBackground(Object... params) {
        String rol = autor.getClass().getSimpleName();
        switch (rol){
            case "Administrador":
                Administrador varAdministrador = (Administrador) autor;
                switch (accion1){
                    case 1: //Gestion de cursos
                        switch (accion2){
                            case 1: //insertar
                                varAdministrador.insertarCurso();
                                break;
                            case 2: //mostrar
                                varAdministrador.modificarCurso();
                                break;
                            case 3: //modificar
                                varAdministrador.modificarCurso();
                                break;
                            case 4: //eliminar
                                varAdministrador.eliminarCurso();
                                break;
                        }
                        break;
                    case 2: //Gestion de docentes
                        switch (accion2){
                            case 1: //insertar
                                resultado = varAdministrador.insertarDocente((long) params[0], (String)params[1], (String)params[2], (String)params[3], (String)params[4]);
                                break;
                            case 2: //mostrar
                                varAdministrador.mostrarDocente();
                                break;
                            case 3: //modificar
                                varAdministrador.modificarDocente();
                                break;
                            case 4: //eliminar
                                varAdministrador.eliminarDocente();
                                break;
                        }
                        break;
                    case 3: //Gestion de estudiantes
                        switch (accion2){
                            case 1: //insertar
                                resultado = varAdministrador.insertarEstudiante((long) params[0], (String)params[1], (String)params[2], (String)params[3], (String)params[4], (String)params[5]);
                                break;
                            case 2: //mostrar
                                varAdministrador.mostrarEstudiante();
                                break;
                            case 3: //modificar
                                varAdministrador.modificarEstudiante();
                                break;
                            case 4: //eliminar
                                varAdministrador.eliminarEstudiante();
                                break;
                        }
                        break;
                    case 4: //asignacion de docentes y est a un curso
                        switch (accion2){
                            case 1: //Asignar estudiante
                                varAdministrador.asignarEstudianteCurso();
                                break;
                            case 2: //Asignar docente
                                varAdministrador.asignarDocenteCurso();
                                break;
                        }
                        break;
                }
                break;
            case "Docente":
                Docente varDocente = (Docente) autor;
                switch (accion1){
                    case 1: //Noticias del curso
                        switch (accion2){
                            case 1: //publicar noticia
                                varDocente.agregarNoticias((int)params[0]);
                                break;
                        }
                        break;
                    case 2: //Tareas del curso
                        switch (accion2){
                            case 1: //publicar tarea
                                varDocente.agregarTareas((int)params[0]);
                                break;
                        }
                        break;
                    case 3: //Chat del curso
                        switch (accion2){
                            case 1: //enviar mensaje
                                varDocente.enviarMensaje(params[0].toString());
                                break;
                        }
                        break;
                    case 4: //Lista de estudiantes
                        switch (accion2){
                            case 1: //ver lista estudiantes
                                varDocente.visualizarEstudiantes((int)params[0]);
                                break;
                        }
                        break;
                }
                break;
            case "Estudiante":
                Estudiante varEstudiante = (Estudiante) autor;
                switch (accion1){
                    case 1: //Noticias del curso Estudiantes
                        switch (accion2){
                            case 1: //ver lista noticia
                                varEstudiante.visualizarListaNoticias((int)params[0]);
                                break;
                            case 2: //ver noticia
                                varEstudiante.visualizarNoticia((int)params[0]);
                                break;
                        }
                        break;
                    case 2: //Tareas del curso Estudiantes
                        switch (accion2){
                            case 1: //ver tarea
                                resultado = varEstudiante.visualizarListaTareas((int)params[0]);
                                break;
                            case 2: //ver tarea
                                varEstudiante.visualizarTarea((int)params[0]);
                                break;
                        }
                        break;
                    case 3: //Chat del curso Estudiantes
                        switch (accion2){
                            case 1: //enviar mensaje
                                varEstudiante.enviarMensaje(params[0].toString());
                                break;
                        }
                        break;
                    case 4: //Profesor encargado
                        switch (accion2){
                            case 1: //ver profesor
                                varEstudiante.visualizarProfesor((int)params[0]);
                                break;
                            case 2: //calificar profesor
                                varEstudiante.calificarProfesor((int)params[0]);
                                break;
                        }
                        break;
                }
                break;
        }
        return resultado;
    }

    protected void onPostExecute(String resultado){
        Toast.makeText(context.get(),resultado,Toast.LENGTH_LONG).show();
    }
}
