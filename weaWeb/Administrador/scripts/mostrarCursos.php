<?php include("includes/header.php") ?>
<div class="container p-3" style="height: 100%;display: flex; justify-content: center;align-items: center;">
        <div class="row">
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>idCurso</th>
                        <th>Nombre</th>
                        <th>Grado</th>
                    </tr>
                </thead>
                <tbody>
<?php

    $conexion = mysqli_connect("localhost","312306","eeerrr96","312306");

    if(!$conexion)
    {
        exit("Error al intentar conectarse al servidor MYSQL.");
    }
    
    $query = "SELECT idCurso,nombre,grado FROM Curso";

    // Ejecutar la consulta
    $resultado = mysqli_query($conexion, $query);

    while($consulta = mysqli_fetch_array($resultado)){
        echo "<td>{$consulta['idCurso']}</td><td>{$consulta['nombre']}</td><td>{$consulta['grado']}</td>";?>
        <td><a href="actualizarCurso.php?idCurso=<?php echo $consulta['idCurso'] ?>"><img src="https://img.icons8.com/small/452/edit.png" width="16" height="16"></a></td>
        <td><a href="borrarCurso.php?idCurso=<?php echo $consulta['idCurso'] ?>"><img src="https://img.icons8.com/small/452/delete-sign.png" width="16" height="16"></a></td>
<?php
    }
    mysqli_close($conexion);
?>
</tbody>
            </table>
        </div>
    </div>
<button type="button" class="btn btn-primary">Agregar Curso</button>
<?php include("includes/footer.php") ?>
					