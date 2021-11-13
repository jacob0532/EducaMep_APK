<?php

include("../db.php");

if(isset($_POST['loginAdmin'])){
    $user = $_POST['user'];
    $password = $_POST['password'];
    
    $query = "SELECT cedula FROM `administrador` WHERE correo='$user' and password='$password'";
    $result = mysqli_query($conn, $query);
    if (!$result){
        $_SESSION['message'] = 'Usuario o contraseña incorrectas';
        $_SESSION['message_type'] = 'danger';
    }else{
        $_SESSION['idUser'] = mysqli_fetch_array($result)['cedula'];
        $_SESSION['typeUser'] = 'Administrador';
        header("Location: ../Administrador/index.php");
    }
}

if(isset($_POST['loginDocente'])){
    $user = $_POST['username'];
    $password = $_POST['password'];
    
    $query = "SELECT cedula FROM `docente` WHERE correo='$user' and password='$password'";
    $result = mysqli_query($conn, $query);
    if (!$result){
        $_SESSION['message'] = 'Usuario o contraseña incorrectas';
        $_SESSION['message_type'] = 'danger';
    }else{
        $_SESSION['idUser'] = mysqli_fetch_array($result)['cedula'];
        $_SESSION['typeUser'] = 'Docente';
        header("Location: ../Docente/index.php?id=$user");
    }
}

if(isset($_POST['loginEstudiante'])){
    $user = $_POST['user'];
    $password = $_POST['password'];
    
    $query = "SELECT cedula FROM `estudiante` WHERE correo='$user' and password='$password'";
    $result = mysqli_query($conn, $query);
    if (!$result){
        $_SESSION['message'] = 'Usuario o contraseña incorrectas';
        $_SESSION['message_type'] = 'danger';
    }else{
        $_SESSION['idUser'] = mysqli_fetch_array($result)['cedula'];
        $_SESSION['typeUser'] = 'Estudiante';
        header("Location: ../Estudiante/index.php");
    }
}

?>