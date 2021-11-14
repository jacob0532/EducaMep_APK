<?php

include("../../db.php");

if(isset($_GET['id'])){
    $id = $_GET['id'];

    if(!isset($_SESSION['idCurso']) or $_SESSION['idCurso']!=$id){
        $_SESSION['idCurso'] = $id;
        $_SESSION['message'] = 'Curso seleccionado!';
        $_SESSION['message_type'] = 'success';
    } else{
        unset($_SESSION['idCurso']);
    }

    header("Location: ../index.php");
}


?>