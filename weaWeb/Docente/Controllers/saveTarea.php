<?php

include("../../db.php");

if(isset($_POST['saveTarea'])){
    $titulo= $_POST['titulo'];
    $idCurso= $_SESSION['idCurso'];
    $descripcion= $_POST['descripcion'];
    $fechaEntrega= $_POST['fechaE'];
    $fechaAsignacion = date('Y-m-d', time());
    
    $query = "INSERT INTO `tarea`(`titulo`, `idCurso`, `descripcion`, `fechaEntrega`, `fechaAsignacion`) 
                    VALUES ('$titulo', '$idCurso', '$descripcion', '$fechaEntrega', NOW());";
    $result = mysqli_query($conn, $query);
    if (!$result){
        die("query failed");
    }

    $_SESSION['message'] = 'Tarea guardada y enviada!';
    $_SESSION['message_type'] = 'success';

    header("Location: ../asignarTarea.php");
}

?>