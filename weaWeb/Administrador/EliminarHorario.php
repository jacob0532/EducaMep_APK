<?php include("includes/db.php") ?>
<?php 

if(isset($_POST['enviarHorario'])){
    $idHorario = $_POST['idHorario'];
    $_SESSION['idHorarioAdmin'] = $idHorario;
    header("Location: AgregarHorario.php" );
}
if(isset($_POST['enviarHorario2'])){
    $_SESSION['cursoAdmin'] = $_GET['idCurso'];
    $_SESSION['nombreAdmin'] = $_GET['nombre'];
    $idHorario = $_POST['idHorario'];
    $_SESSION['idHorarioAdmin'] = $idHorario;
    header("Location: ModificarCurso.php" );
}
?>