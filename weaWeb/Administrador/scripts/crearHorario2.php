<?php include("../includes/db.php") ?>
<?php
    $idCurso= $_GET['idCurso'];
    $_SESSION['cursoAdmin'] = $_GET['idCurso'];
    $_SESSION['nombreAdmin'] = $_GET['nombre'];
    $dia= $_POST['dia'];
    $horaInicio= $_POST['horaInicio'];
    $horaFinal= $_POST['horaFinal'];

    $query = "INSERT INTO Horario (idCurso,horaInicio,horaFinal,dia) VALUES ('$idCurso','$horaInicio','$horaFinal','$dia')";

    if(mysqli_query($conn, $query)){
        echo "Added successfully.";
        header("Location: ../ModificarCurso.php" );
    } else{
        echo "ERROR: Could not able to execute $query. " . mysqli_error($conn);
        header("Location: ../ModificarCurso.php" );
    }    
?>		