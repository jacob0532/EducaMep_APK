<?php include("../includes/db.php") ?>
<?php include("../../mail.php") ?>
<?php
    
    $cedula= $_POST['cedula'];
    $nombre= $_POST['nombre'];
    $apellido1= $_POST['apellido1'];
    $apellido2= $_POST['apellido2'];
    $correo= $_POST['correo'];
    $password = (rand(1,10)*1000)+(rand(1,10)*100)+(rand(1,10)*10)+(rand(1,10)*1);
  
    sendMail("Bienvenido a EducaMep", "<img src='https://lh3.googleusercontent.com/proxy/giwxuwLduWE7YMF8QKLxkhAJJkn2gh-JgvFLOxQh2WUqvdkS2iS12fmhBABbOJiR3v7aX2Mt90usq5Em9_glVs5LTKOXwpr6hUXeZANGHZRY6ORcKYi-L2iKf6rg5CjwV1HgbDMlKIfEiMl5twRXvGiC6Cs'
    width='400'
    height='341'>
    <h3>User: {$correo}</h3>
    <h3>Password: {$password} </h3>", $correo);


   
    if(empty($cedula) or empty($nombre) or empty($apellido1) or empty($apellido2) or empty($correo)){
        header("Location: ../GestionDocente.php" );
    }
    else{
        $query = "INSERT INTO Docente (cedula,nombre,apellido1,apellido2,correo,password) VALUES ('$cedula','$nombre','$apellido1','$apellido2','$correo','$password')";

        if(mysqli_query($conn, $query)){
            echo "Added successfully.";
            header("Location: ../GestionDocente.php" );
        } else{
            echo "ERROR: Could not able to execute $query. " . mysqli_error($conn);
        }

    }
         
    
?>		