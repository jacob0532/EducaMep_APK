<?php include("includes/db.php") ?>

<?php
  
    $idCurso= $_GET['idCurso'];

    if(empty($idCurso) ){
        header("Location: GestionCurso.php" );
    }

    $query = "DELETE FROM Curso WHERE idCurso='$idCurso'";

    if(mysqli_query($conn, $query)){
        echo "Deleted successfully.";
        header("Location: GestionCurso.php" );
    } else{
        echo "ERROR: Could not able to execute $query. " . mysqli_error($conn);
        header("Location: GestionCurso.php" );
    }
   
    
?>