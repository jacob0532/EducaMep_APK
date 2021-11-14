<?php

include("../../db.php");

if(isset($_GET['id']) and isset($_GET['cal'])){
    $calificacion= $_GET['cal'];
    $idCurso= $_SESSION['idCurso'];
    $idDocente= $_GET['id'];
    $idEstudiante= $_SESSION['idUser'];

    $sql = "SELECT idCalificacion FROM Calificacion 
            WHERE estudiante='$idEstudiante' AND docente='$idDocente' AND idCurso='$idCurso'";


    if ($result=mysqli_query($conn,$sql)) {
        $rowcount=mysqli_num_rows($result);
    }

    if($rowcount==0){
        $query = "INSERT INTO `Calificacion`(`calificacion`, `estudiante`, `docente`, `idCurso`) VALUES ('$calificacion','$idEstudiante',$idDocente,'$idCurso')";
        mysqli_query($conn, $query);  

        $_SESSION['message'] = 'Calificado correctamente!';
        $_SESSION['message_type'] = 'success';

        header("Location: ../verProfesor.php");         


    }else{
        $query = "UPDATE Calificacion SET calificacion='$calificacion' WHERE (estudiante='$idEstudiante' AND docente='$idDocente' AND idCurso='$idCurso')";
        mysqli_query($conn, $query);

        $_SESSION['message'] = 'Calificado Correctamente!';
        $_SESSION['message_type'] = 'success';

        header("Location: ../verProfesor.php"); 
    }
  
}

?>			