<?php

include("../db.php");

if(isset($_POST['loginAdmin'])){
    $user = $_POST['username'];
    $password = $_POST['password'];
    
    $query = "SELECT cedula FROM `Administrador` WHERE correo='$user' and password='$password'";
    $result = mysqli_query($conn, $query);
    $row_cnt = mysqli_num_rows($result);
    if (!$result or $row_cnt==0){
        $_SESSION['message'] = 'Usuario o contraseña incorrectas';
        $_SESSION['message_type'] = 'danger';
        header("Location: ../login.php?type=adm");
    }else{
        $_SESSION['idUser'] = mysqli_fetch_array($result)['cedula'];
        $_SESSION['typeUser'] = 'Administrador';
        $id = $_SESSION['idUser'];
        header("Location: ../Administrador/index.php?id=$id");
    }
}

if(isset($_POST['loginDocente'])){
    $user = $_POST['username'];
    $password = $_POST['password'];
    
    $query = "SELECT cedula FROM `Docente` WHERE correo='$user' and password='$password'";
    $result = mysqli_query($conn, $query);
    $row_cnt = mysqli_num_rows($result);
    if (!$result or $row_cnt==0){
        $_SESSION['message'] = 'Usuario o contraseña incorrectas';
        $_SESSION['message_type'] = 'danger';
        header("Location: ../login.php?type=doc");
    }else{
        $_SESSION['idUser'] = mysqli_fetch_array($result)['cedula'];
        $_SESSION['typeUser'] = 'Docente';
        $id = $_SESSION['idUser'];
        header("Location: ../Docente/index.php?id=$id");
    }
}

if(isset($_POST['loginEstudiante'])){
    $user = $_POST['username'];
    $password = $_POST['password'];
    
    $query = "SELECT cedula FROM `Estudiante` WHERE correo='$user' and password='$password'";
    $result = mysqli_query($conn, $query);
    $row_cnt = mysqli_num_rows($result);
    if (!$result or $row_cnt==0){
        $_SESSION['message'] = 'Usuario o contraseña incorrectas';
        $_SESSION['message_type'] = 'danger';
        header("Location: ../login.php?type=est");
    }else{
        $_SESSION['idUser'] = mysqli_fetch_array($result)['cedula'];
        $_SESSION['typeUser'] = 'Estudiante';
        $id = $_SESSION['typeUser'];
        header("Location: ../Estudiante/index.php?id=$id");
    }
}

?>			