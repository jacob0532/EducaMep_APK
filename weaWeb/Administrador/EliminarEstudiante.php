<?php include("includes/db.php") ?>
<?php
    $cedula= $_GET['cedula'];

    if(empty($cedula) ){
        header("Location: GestionEstudiante.php" );
    }

    $query = "DELETE FROM Estudiante WHERE cedula='$cedula'";

    if(mysqli_query($conn, $query)){
        echo "Deleted successfully.";
        header("Location: GestionEstudiante.php" );
    } else{
        echo "ERROR: Could not able to execute $query. " . mysqli_error($conn);
        header("Location: GestionEstudiante.php" );
    }
?>