<?php
$conn = mysqli_connect(
    'localhost',
    '312306',
    'eeerrr96',
    '312306'
);

session_start();
if(!$conn){
    exit("Error al intentar conectarse al servidor MYSQL.");
}

error_reporting(0);
?>