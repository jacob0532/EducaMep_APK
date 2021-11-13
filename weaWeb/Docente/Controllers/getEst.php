<?php

include("../../db.php");

if(isset($_GET['id'])){
    $id = $_GET['id'];
    $query = "SELECT * FROM `estudiante` WHERE cedula = '$id'";
    $result = mysqli_query($conn, $query);

    if (!$result){
        die ("Query failed");
    }
    $_SESSION['data'] = mysqli_fetch_array($result);

    header("Location: ../estudiante.php");
}

?>