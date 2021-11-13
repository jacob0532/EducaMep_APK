<?php

include("../../db.php");

if(isset($_POST['saveNews'])){
    $tittle = $_POST['titulo'];
    $description = $_POST['descripcion'];
    $idCurso= $_SESSION['idCurso'];
    
    $query = "INSERT INTO `noticia`(`titulo`, `idCurso`, `texto`, `fecha`) VALUES ('$tittle', '$idCurso', '$description', NOW());";
    $result = mysqli_query($conn, $query);
    if (!$result){
        die("query failed");
    }

    $_SESSION['message'] = 'Noticia guardada y enviada!';
    $_SESSION['message_type'] = 'success';

    header("Location: ../publicarNoticia.php");
}

?>