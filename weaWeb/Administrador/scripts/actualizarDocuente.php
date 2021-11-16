<?php include("../includes/db.php") ?>
<?php
    
    $cedula= $_POST['cedula'];
    $nombre= $_POST['nombre'];
    $apellido1= $_POST['apellido1'];
    $apellido2= $_POST['apellido2'];
    $correo= $_POST['correo'];

    if(empty($cedula) or empty($nombre) or empty($apellido1) or empty($apellido2) or empty($correo)){
        header("Location: ../GestionDocente.php" );
    }
    else{
        $query = "UPDATE Docente SET nombre='$nombre',apellido1='$apellido1',apellido2='$apellido2',correo='$correo' WHERE cedula='$cedula' ";
        if(mysqli_query($conn, $query)){
            echo "Updated successfully.";
            header("Location: ../GestionDocente.php" );
        } else{
            echo "ERROR: Could not able to execute $query. " . mysqli_error($conn);
            header("Location: ../GestionDocente.php" );
        }
    }

?>