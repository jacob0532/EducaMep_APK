<?php

include("../../db.php");

if(isset($_POST['saveTarea'])){
    if ($_POST['saveTarea'] == null or $_POST['descripcion'] == null or $_POST['fechaE']== null){
        $_SESSION['message'] = 'Rellene todos los campos';
        $_SESSION['message_type'] = 'danger';
    
        header("Location: ../asignarTarea.php");
    }else{
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
    
}

?>