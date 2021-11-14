<?php

include("../../db.php");

    $nombre = mysqli_real_escape_string($conn, $_POST['nombreUser']);
    $idCurso = mysqli_real_escape_string($conn, $_POST['idCurso']);
    $msg = mysqli_real_escape_string($conn, $_POST['message']);

    if(!empty($msg)){
        $query = "INSERT INTO `Chat`(`mensaje`, `nombre`, `idCurso`) VALUES ('$msg', '$nombre', '$idCurso')";
        $result = mysqli_query($conn, $query) or die();
    }

?>