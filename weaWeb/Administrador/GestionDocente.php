<?php include("includes/db.php") ?>

<?php include("includes/header.php") ?>


<div class="container p-2 m-5 text-center">
        <div class="row">
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Cedula</th>
                        <th>Nombre</th>
                        <th>Apellido1</th>
                        <th>Apellido2</th>
                        <th>Correo</th>
                        <th>Calificacion Promedio</th>
                        <th># Calificaciones</th>
                    </tr>
                </thead>
                <tbody>
<?php
    $query = "SELECT cedula,nombre,apellido1,apellido2,correo FROM Docente";

    // Ejecutar la consulta
    $resultado = mysqli_query($conn, $query);

    while($consulta = mysqli_fetch_array($resultado)){
        $calPromedio = 0;
        $numPromedios = 0;
        $query2 = "SELECT calificacion FROM `calificacion` WHERE docente = {$consulta['cedula']} "; 
        $resultado2 = mysqli_query($conn, $query2);
        while($consulta2 = mysqli_fetch_array($resultado2)){
            $calPromedio = $calPromedio + $consulta2['calificacion'];
            $numPromedios = $numPromedios + 1;
        }
        if ($numPromedios != 0) {
            $calPromedio = $calPromedio/$numPromedios;
        }
        echo "<tr><td>{$consulta['cedula']}</td><td>{$consulta['nombre']}</td><td>{$consulta['apellido1']}</td><td>{$consulta['apellido2']}</td><td>{$consulta['correo']}</td><td>{$calPromedio}</td><td>{$numPromedios}</td>";?>
        <td> 
            <form action="controller/setModelEst.php" method="POST">
                <input type="text" class="idDocente" name="idDocente" value="<?php echo "{$consulta['cedula']}";?>" hidden></input>
                <button type="submit" name="setCedDoc" class='btn btn-primary'>Cursos que Imparte</button>
            </form>
        </td>
        <td><a href="ModificarDocente.php?cedula=<?php echo $consulta['cedula'] ?>&nombre=<?php echo $consulta['nombre']?>&apellido1=<?php echo $consulta['apellido1']?>&apellido2=<?php echo $consulta['apellido2']?>&correo=<?php echo $consulta['correo']?>"><img src="https://img.icons8.com/small/452/edit.png" width="25" height="25"></a></td>
        <td><a href="EliminarDocente.php?cedula=<?php echo $consulta['cedula'] ?>"><img src="https://img.icons8.com/small/452/delete-sign.png" width="25" height="25"></a></td></tr>
<?php
    }
?>
</tbody>
            </table>
        </div>
    </div>

    <?php 
    if (isset($_SESSION['idDocenteAdmin'])){
        $query2 = "SELECT C.idCurso, C.nombre, C.grado 
        FROM Curso C INNER JOIN CursosDocente CE ON C.idCurso = CE.idCurso
        WHERE CE.cedula = '{$_SESSION['idDocenteAdmin']}' AND CE.periodo=(SELECT YEAR(NOW()))";
        $resultado2 = mysqli_query($conn, $query2);
        echo "
                    <div class='container'>
                        <div class='alert alert-success alert-dismissible'>
                            <button type='button' class='close' data-dismiss='alert'>&times;</button>
                                <table class='table table-sm table-striped'>
                                    <thead>
                                        <tr>
                                            <th>idCurso</th>
                                            <th>Nombre</th>
                                            <th>Grado</th>
                                        </tr>
                                    </thead>
                                    <tbody>";
        while($consulta2 = mysqli_fetch_array($resultado2)){
            echo "<tr>
                                    <tr><td>{$consulta2['idCurso']}</td>
                                    <td>{$consulta2['nombre']}</td>
                                    <td>{$consulta2['grado']}</td> <tr>";

        }
        echo "                      </tbody>
                                </table>
                            </div>
                        </div>
                    ";
        unset($_SESSION['idDocenteAdmin']);
    }
    ?>


    <div class="col text-left m-5">
            <button type="button" onclick= "window.location.href ='AgregarDocente.php'" class="btn btn-primary btn-lg">Agregar Docente</button>

            </div>

<?php include("includes/footer.php") ?>