<?php include("includes/db.php") ?>
<?php
    $cedula= $_GET['cedula'];

    if(empty($cedula) ){
        header("Location: GestionDocente.php" );
    }

    $query = "DELETE FROM Docente WHERE cedula='$cedula'";

    if(mysqli_query($conn, $query)){
        echo "Deleted successfully.";
        header("Location: GestionDocente.php" );
    } else{
        echo "ERROR: Could not able to execute $query. " . mysqli_error($conn);
        header("Location: GestionDocente.php" );
    }
?>

