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
                        <th>Grado</th>
                    </tr>
                </thead>
                <tbody>
<?php
    $query = "SELECT cedula,nombre,apellido1,apellido2,correo,grado FROM Estudiante";

    // Ejecutar la consulta
    $resultado = mysqli_query($conn, $query);
    while($consulta = mysqli_fetch_array($resultado)){
        echo "<tr><td>{$consulta['cedula']}</td><td>{$consulta['nombre']}</td><td>{$consulta['apellido1']}</td><td>{$consulta['apellido2']}</td><td>{$consulta['correo']}</td><td>{$consulta['grado']}</td>";?>
        <td> 
            <form action="controller/setModelEst.php" method="POST">
                <input type="text" class="idEstudiante" name="idEstudiante" value="<?php echo "{$consulta['cedula']}";?>" hidden></input>
                <button type="submit" name="setCedEst" class='btn btn-primary'>Lista de Cursos</button>
            </form>
        </td>
        <td><a href="ModificarEstudiante.php?cedula=<?php echo $consulta['cedula'] ?>&nombre=<?php echo $consulta['nombre']?>&apellido1=<?php echo $consulta['apellido1']?>&apellido2=<?php echo $consulta['apellido2']?>&correo=<?php echo $consulta['correo']?>&grado=<?php echo $consulta['grado']?>"><img src="https://img.icons8.com/small/452/edit.png" width="25" height="25"></a></td>
        <td><a href="EliminarEstudiante.php?cedula=<?php echo $consulta['cedula'] ?>"><img src="https://img.icons8.com/small/452/delete-sign.png" width="25" height="25"></a></td></tr>
<?php
    }
?>
                </tbody>
            </table>
        </div>
    </div>

    <?php 
    if (isset($_SESSION['idEstudianteAdmin'])){
        $query2 = "SELECT C.idCurso, C.nombre, C.grado 
        FROM Curso C INNER JOIN CursosEstudiantes CE ON C.idCurso = CE.idCurso
        WHERE CE.cedula = '{$_SESSION['idEstudianteAdmin']}' AND CE.periodo=(SELECT YEAR(NOW()))";
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
        unset($_SESSION['idEstudianteAdmin']);
    }
    ?>
    <div class="col text-left m-5">
        <button type="button" onclick= "window.location.href ='AgregarEstudiante.php'" class="btn btn-primary btn-lg">Agregar Estudiante</button>
    </div>
<?php include("includes/footer.php") ?>