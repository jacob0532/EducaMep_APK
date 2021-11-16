<?php
$conn = mysqli_connect(
    'localhost',
    '312306',
    'eeerrr96',
    '312306'
);

session_start();
/*
$conn = mysqli_connect(
    'localhost',
    '312306',
    'eeerrr96',
    '312306'
);
$conn = mysqli_connect(
    'localhost',
    'root',
    '',
    'EducaMEP'
);
*/

if(!$conn){
    exit("Error al intentar conectarse al servidor MYSQL.");
}

function verifyCurso() : bool {
    if (isset($_SESSION['idCurso'])){
        return false;
    }
    return true;
}

function verifyRightUser(string $type ) : bool{
    if($_SESSION['idUser'] == null and $_SESSION['typeUser'] == null){
        return true;
    }
    if ($_SESSION['typeUser'] != $type){
        return true;
    }
    return false;
}


?>