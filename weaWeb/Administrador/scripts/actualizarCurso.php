<?php include("../includes/db.php") ?>
<?php


    $idCurso= $_POST['idCurso'];
    $nombre= $_POST['nombre'];
    $grado= $_POST['grado'];

    if(empty($idCurso) or empty($nombre) or empty($grado)){
        header("Location: ../GestionCurso.php" );
    }
    else{
        $query = "UPDATE Curso SET nombre='$nombre',grado='$grado' WHERE idCurso='$idCurso'";
        if(mysqli_query($conn, $query)){
            echo "Updated successfully.";
            header("Location: ../GestionCurso.php" );
        } else{
            echo "ERROR: Could not able to execute $query. " . mysqli_error($conn);
            header("Location: ../GestionCurso.php" );
        }
    }    
?>