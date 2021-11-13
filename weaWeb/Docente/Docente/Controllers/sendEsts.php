<?php

include("../../db.php");

if(isset($_GET['id'])){
    $id = $_GET['id'];
    $idCurso = $_SESSION['idCurso'];
    
    /*$message = "Line 1\r\nLine 2\r\nLine 3";
    $message = wordwrap($message, 70, "\r\n");
    mail('kaledsv@gmail.com', 'My Subject', $message);*/

    $_SESSION['message'] = 'Lista Enviada!';
    $_SESSION['message_type'] = 'success';

    header("Location: ../listaEstudiantes.php");
}

?>