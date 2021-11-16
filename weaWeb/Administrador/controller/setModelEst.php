<?php include("../includes/db.php") ?>
<?php 

if(isset($_POST['setCedEst'])){
    $idEst = $_POST['idEstudiante'];
    $_SESSION['idEstudianteAdmin'] = $idEst;
    header("Location: ../GestionEstudiante.php" );
}

if(isset($_POST['setCedDoc'])){
    $idDoc = $_POST['idDocente'];
    $_SESSION['idDocenteAdmin'] = $idDoc;
    header("Location: ../GestionDocente.php" );
}

?>