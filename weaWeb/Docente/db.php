<?php
$conn = mysqli_connect(
    'localhost',
    'root',
    '',
    'EducaMEP'
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

function verifyDocente() : bool {
    if (isset($_SESSION['idCurso'])){
        return false;
    }
    return true;
  }

?>