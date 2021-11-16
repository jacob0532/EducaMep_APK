<?php include("includes/db.php") ?>

<?php include("includes/header.php") ?>
<div class="container p-2 m-5 text-center">
        <div class="row">
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>idCurso</th>
                        <th>Nombre</th>
                        <th>Grado</th>
                    </tr>
                </thead>
                <tbody>
<?php
    $query = "SELECT idCurso,nombre,grado FROM Curso";

    // Ejecutar la consulta
    $resultado = mysqli_query($conn, $query);

    while($consulta = mysqli_fetch_array($resultado)){
        echo "<tr><td>{$consulta['idCurso']}</td><td>{$consulta['nombre']}</td><td>{$consulta['grado']}</td>";?>
        <td><a href="ModificarCurso.php?idCurso=<?php echo $consulta['idCurso'] ?>&nombre=<?php echo $consulta['nombre'] ?>"><img src="https://img.icons8.com/small/452/edit.png" width="25" height="25"></a></td>
        <td><a href="EliminarCurso.php?idCurso=<?php echo $consulta['idCurso'] ?>"><img src="https://img.icons8.com/small/452/delete-sign.png" width="25" height="25"></a></td></tr>
<?php
    }
?>
</tbody>
            </table>
        </div>
    </div>
    <div class="col text-left m-5">
        <button type="button" onclick= "window.location.href ='AgregarCurso.php'" class="btn btn-primary btn-lg">Agregar Curso</button>
    </div>



<?php include("includes/footer.php") ?>