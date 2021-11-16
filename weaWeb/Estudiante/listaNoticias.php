<?php include("../db.php") ?>

<?php include("includes/header.php") ?>
<?php if(verifyRightUser('Estudiante')){ 
        $_SESSION['message'] = 'Quedese en su interfaz >:c!';
        $_SESSION['message_type'] = 'danger';
        $typeUser = $_SESSION['typeUser'];
        header("Location: ../$typeUser/index.php");
    }
    if(verifyCurso()){
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
                                <th>Mensaje</th>
                                <th>Fecha</th>
                                <th>ID Tarea</th>
                            </tr>
                        </thead>
                        <tbody>
                            <?php
                            $idCurso = $_SESSION['idCurso'];
                                $query = "SELECT N.titulo,N.texto,N.fecha,N.idNoticia
                                                FROM Noticia N INNER JOIN Curso C ON C.idCurso=N.idCurso
                                                WHERE C.idCurso='$idCurso'";

                                $result = mysqli_query($conn, $query);

                                while($row = mysqli_fetch_array($result)){?>
                                    <tr>
                                        <td><?php echo $row['titulo'] ?></td>
                                        <td><?php echo $row['texto'] ?></td>
                                        <td><?php echo $row['fecha'] ?></td>
                                        <td><?php echo $row['idNoticia'] ?></td>
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