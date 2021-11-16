<?php

include("../includes/db.php"); 

if(isset($_POST['AsignarDoc'])){
    $cedula= $_POST['id_docente'];
    $idCurso= $_POST['id_curso'];
    $fecha = date('Y', time());

    $sql = "SELECT cedula FROM CursosDocente 
            WHERE periodo='$fecha' AND cedula='$cedula' AND idCurso='$idCurso'";

    if ($result=mysqli_query($conn,$sql)) {
        $rowcount=mysqli_num_rows($result);
    }
    if($rowcount==0){
        $query = "INSERT INTO `CursosDocente` (`periodo`,`idCurso`,`cedula`) 
                                    VALUES ('$fecha','$idCurso','$cedula')";
        $result = mysqli_query($conn, $query);
        if (!$result){
            die("query failed");
        }
        $_SESSION['message'] = 'Docente asignado al curso!';
        $_SESSION['message_type'] = 'success';
        header("Location: ../asignarDocente.php");

    }else{
        $_SESSION['message'] = 'El docente ya ha sido asignado al curso!';
        $_SESSION['message_type'] = 'success';
        header("Location: ../asignarDocente.php");
    }
}


if(isset($_POST['EliminarDoc'])){
    $cedula= $_POST['id_docente'];
    $idCurso= $_POST['id_curso'];
    $fecha = date('Y', time());

    $sql = "SELECT cedula FROM CursosDocente WHERE periodo='$fecha' AND cedula='$cedula' AND idCurso='$idCurso'";

    if ($result=mysqli_query($conn,$sql)) {
        $rowcount=mysqli_num_rows($result);
    }
    if($rowcount==0){
        header("Location: ../asignarDocente.php");
    
    }else{
    
        $query = "DELETE FROM `CursosDocente` WHERE `periodo`='$fecha' AND `idCurso`='$idCurso' AND `cedula`='$cedula'";
        $result = mysqli_query($conn, $query);
        if (!$result){
            die("query failed");
        }
        $_SESSION['message'] = 'Docente relegado del curso!';
        $_SESSION['message_type'] = 'success';
        header("Location: ../asignarDocente.php");
    }

}

if(isset($_POST['actualizar'])){
    $cedula= $_POST['id_docente'];
    $_SESSION['id_docenteTabla']=$cedula;


    $_SESSION['message'] = 'Cursos del profesor!';
    $_SESSION['message_type'] = 'success';

    header("Location: ../asignarDocente.php");
}

?>  