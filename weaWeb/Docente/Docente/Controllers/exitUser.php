<?php

include("../../db.php");

$_SESSION['message'] = 'Sesion terminada!';
$_SESSION['message_type'] = 'success';
unset($_SESSION['idUser']);
unset($_SESSION['typeUser']);
unset($_SESSION['idCurso']);

header("Location: ../../index.php");

?>