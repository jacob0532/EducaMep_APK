<?php include("../includes/db.php") ?>
<?php
    $cedula= $_POST['cedula'];
    $nombre= $_POST['nombre'];
    $apellido1= $_POST['apellido1'];
    $apellido2= $_POST['apellido2'];
    $correo= $_POST['correo'];
    $grado = $_POST['grado'];

    if(empty($grado) or empty($cedula) or empty($nombre) or empty($apellido1) or empty($apellido2) or empty($correo)){
        header("Location: ../GestionEstudiante.php" );
    }
    else{
        $query = "UPDATE Estudiante SET nombre='$nombre',apellido1='$apellido1',apellido2='$apellido2',correo='$correo',grado='$grado' WHERE cedula='$cedula' ";

        if(mysqli_query($conn, $query)){
            echo "Updated successfully.";
            header("Location: ../GestionEstudiante.php" );
        } else{
            echo "ERROR: Could not able to execute $query. " . mysqli_error($conn);
            header("Location: ../GestionEstudiante.php" );
        }

    }
         
?>