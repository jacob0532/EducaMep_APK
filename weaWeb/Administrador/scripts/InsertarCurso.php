<?php include("includes/header.php") ?>
<?php
    error_reporting(0);

    $conexion = mysqli_connect("localhost","312306","eeerrr96","312306");

    if(!$conexion)
    {
        exit("Error al intentar conectarse al servidor MYSQL.");
    }

    $nombre= $_POST['nombre'];
    $grado= $_POST['grado'];
   

    if( empty($nombre) or empty($grado)){
        exit("ERROR: debe llenar todos los espacios.");
    }

    $query = "INSERT INTO Curso (nombre,grado) VALUES ('$nombre','$grado')";

    if(mysqli_query($conexion, $query)){
        echo "Added successfully.";
    } else{
        echo "ERROR: Could not able to execute $query. " . mysqli_error($conexion);
    }
     
    // Close connection
    mysqli_close($conexion);
?>

<?php include("includes/footer.php") ?>	