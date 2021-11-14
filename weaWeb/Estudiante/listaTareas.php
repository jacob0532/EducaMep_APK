<?php include("../db.php") ?>

<?php include("includes/header.php") ?>
<?php if(verifyRightUser('Estudiante')){ 
        $_SESSION['message'] = 'Quedese en su interfaz >:c!';
        $_SESSION['message_type'] = 'danger';
        $typeUser = $_SESSION['typeUser'];
        header("Location: ../$typeUser/index.php");
    }
    if(verifyDocente()){
        $_SESSION['message'] = 'Debe Seleccionar un curso!';
        $_SESSION['message_type'] = 'danger';
        header("Location: index.php");
    }else{?>
    <div class="container p-3" style="height: 100%;display: flex;justify-content: center;align-items: center;">
        <div class="row">
            <div class="col-md-auto">
                <?php if(isset($_SESSION['message'])){ ?>
                    <div class="alert alert-<?= $_SESSION['message_type'] ?> alert-dismissible fade show" role="alert" style="margin-bottom: 15px;">
                        <?= $_SESSION['message'] ?>
                        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                    </div>
                <?php unset($_SESSION['message']);
                      unset($_SESSION['message_type']);
                } ?>
                <div class="card card-body text-center">
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>Titulo</th>
                                <th>Descripcion</th>
                                <th>Fecha Asignacion</th>
                                <th>Fecha Entrega</th>
                                <th>ID Tarea</th>
                            </tr>
                        </thead>
                        <tbody>
                            <?php
                            $idCurso = $_SESSION['idCurso'];
                                $query = "SELECT T.titulo,T.descripcion,T.fechaAsignacion,T.fechaEntrega,T.idTarea
                                                FROM Tarea T INNER JOIN Curso C ON C.idCurso=T.idCurso
                                                WHERE C.idCurso='$idCurso'"; 

                                $result = mysqli_query($conn, $query);

                                while($row = mysqli_fetch_array($result)){?>
                                    <tr>
                                        <td><?php echo $row['titulo'] ?></td>
                                        <td><?php echo $row['descripcion'] ?></td>
                                        <td><?php echo $row['fechaAsignacion'] ?></td>
                                        <td><?php echo $row['fechaEntrega'] ?></td>
                                        <td><?php echo $row['idTarea'] ?></td>
                                    </tr>
                                <?php } 
                            ?>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
<?php } ?>
<?php include("includes/footer.php") ?>