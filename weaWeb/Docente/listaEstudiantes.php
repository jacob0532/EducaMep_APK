<?php include("../db.php") ?>

<?php include("includes/header.php") ?>
<?php if(verifyRightUser('Docente')){ 
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
                                <th>Nombre</th>
                                <th>Primer apellido</th>
                                <th>Segundo apellido</th>
                                <th>Cedula</th>
                            </tr>
                        </thead>
                        <tbody>
                            <?php
                                $idCurso = $_SESSION['idCurso'];
                                $query = "SELECT E.nombre as 'nombre', E.apellido1  as 'apellido1', E.apellido2 as 'apellido2', E.cedula as 'cedula'
                                                FROM Estudiante E INNER JOIN CursosEstudiantes CE ON CE.cedula=E.cedula
                                                WHERE (CE.idCurso='$idCurso' AND CE.periodo=(SELECT YEAR(NOW())) )";
                                $result = mysqli_query($conn, $query);

                                while($row = mysqli_fetch_array($result)){?>
                                    <tr>
                                        <td><?php echo $row['nombre'] ?></td>
                                        <td><?php echo $row['apellido1'] ?></td>
                                        <td><?php echo $row['apellido2'] ?></td>
                                        <td><?php echo $row['cedula'] ?></td>
                                        <td>
                                            <a href="Controllers/getEst.php?id=<?php echo $row['cedula'] ?>">
                                                <img src="https://img.icons8.com/small/452/connection-status-off.png" width="16" height="16">
                                            </a>
                                        </td>
                                    </tr>
                                <?php } 
                            ?>
                        </tbody>
                    </table>
                </div>
                <a href="Controllers/sendEsts.php?id=18" class="btn btn-info" style="width: 100%;margin-top: 15px;">Enviar Lista al correo</a>
            </div>
        </div>
    </div>
<?php } ?>
<?php include("includes/footer.php") ?>