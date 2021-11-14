<?php

include("../../db.php");

$nombre = mysqli_real_escape_string($conn, $_POST['nombreUser']);
$idCurso = mysqli_real_escape_string($conn, $_POST['idCurso']);
$output = "";
$sql = "SELECT `mensaje`, `nombre` FROM `Chat` WHERE `idCurso` = '$idCurso' order by `idChat`";
$query = mysqli_query($conn, $sql);
if(mysqli_num_rows($query) > 0){
    while($row = mysqli_fetch_assoc($query)){
        if($row['nombre'] === $nombre){
            $output .= '<div class="chat outgoing">
                        <div class="details">
                            <p>'. $row['nombre'] .'</p>
                            <p>'. $row['msg'] .'</p>
                        </div>
                        </div>';
        }else{
            $output .= '<div class="chat incoming">
                        <div class="details">
                            <p>'. $row['nombre'] .'</p>
                            <p>'. $row['msg'] .'</p>
                        </div>
                        </div>';
        }
    }
}else{
    $output .= '<div class="text">No hay mensajes disponibles. Se el primero en hablar!</div>';
}
echo $output;

?>