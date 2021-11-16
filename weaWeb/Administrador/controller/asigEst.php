<?php

include("../includes/db.php");

if(isset($_POST['AsignarEst'])){
    $cedula= $_POST['id_estudiante'];
    $idCurso= $_POST['id_curso'];
    $fecha = date('Y', time());
    
    $sql = "SELECT cedula FROM CursosEstudiantes 
            WHERE periodo='$fecha' AND cedula='$cedula' AND idCurso='$idCurso'";

    if ($result=mysqli_query($conn,$sql)) {
        $rowcount=mysqli_num_rows($result);
    }
    if($rowcount==0){
        $query = "INSERT INTO `CursosEstudiantes` (`periodo`,`idCurso`,`cedula`) 
                                VALUES ('$fecha','$idCurso','$cedula')";

        $result = mysqli_query($conn, $query);
        if (!$result){
            die("query failed");
        }
        $_SESSION['message'] = 'Estudiante asignado al curso!';
        $_SESSION['message_type'] = 'success';
        header("Location: ../asignarEstudiante.php");

    }else{
        $_SESSION['message'] = 'El estudiante ya ha sido asignado al curso!';
        $_SESSION['message_type'] = 'success';
        header("Location: ../asignarEstudiante.php");
    }

    
}
if(isset($_POST['EliminarEst'])){
    $cedula= $_POST['id_estudiante'];
    $idCurso= $_POST['id_curso'];
    $fecha = date('Y', time());

    $sql = "SELECT cedula FROM CursosEstudiantes 
            WHERE periodo='$fecha' AND cedula='$cedula' AND idCurso='$idCurso'";

    if ($result=mysqli_query($conn,$sql)) {
        $rowcount=mysqli_num_rows($result);
    }
    if($rowcount==0){
        $_SESSION['message'] = 'No se puede relegar un estudiante de un curso al que no esta asignado!';
        $_SESSION['message_type'] = 'success';
        header("Location: ../asignarEstudiante.php");
    
    }else{
        $query = "DELETE FROM CursosEstudiantes WHERE periodo='$fecha' AND idCurso='$idCurso' AND cedula='$cedula'";

        $result = mysqli_query($conn, $query);
        if (!$result){
            die("query failed");
        }
        $_SESSION['message'] = 'Estudiante relegado del curso!';
        $_SESSION['message_type'] = 'success';
        header("Location: ../asignarEstudiante.php");
    }

        
}
if(isset($_POST['actualizar'])){
    $cedula= $_POST['id_estudiante'];
    $_SESSION['id_estudianteTabla']=$cedula;


    $_SESSION['message'] = 'Estudiantes del Curso!';
    $_SESSION['message_type'] = 'success';

    header("Location: ../asignarEstudiante.php");
}

?>  