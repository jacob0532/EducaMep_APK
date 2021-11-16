<?php include("../includes/db.php") ?>
<?php
    $resultadoVar = mysqli_query($conn, "SELECT max(idCurso) FROM Curso");
    $fila = mysqli_fetch_row($resultadoVar);
    $idCurso= $fila[0];
    $dia= $_POST['dia'];
    $horaInicio= $_POST['horaInicio'];
    $horaFinal= $_POST['horaFinal'];

    $query = "INSERT INTO Horario (idCurso,horaInicio,horaFinal,dia) VALUES ('$idCurso','$horaInicio','$horaFinal','$dia')";

    if(mysqli_query($conn, $query)){
        echo "Added successfully.";
        header("Location: ../AgregarHorario.php" );
    } else{
        echo "ERROR: Could not able to execute $query. " . mysqli_error($conn);
        header("Location: ../AgregarHorario.php" );
    }    
?>			