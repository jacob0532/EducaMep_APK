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
                        <thead class="thead-dark">
                            <tr>
                                <th>Profesor</th>
                            </tr>
                        </thead>
                        <tbody>
                            <?php
                                $idCurso = $_SESSION['idCurso'];
                                $query = "SELECT D.nombre,D.apellido1,D.apellido2,D.correo,D.cedula
                                                FROM Docente D INNER JOIN CursosDocente CD ON CD.cedula=D.cedula
                                                WHERE (CD.idCurso='$idCurso' AND CD.periodo=(SELECT YEAR(NOW())) )";

                                $result = mysqli_query($conn, $query);

                                while($row = mysqli_fetch_array($result)){?>
                                    <tr>
                                        <td>
                                            <div>
                                                <label style="font-weight: bold;">Cedula</p>
                                            </div>
                                            <label><?php echo $row['cedula'] ?></label>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <div>
                                                <label style="font-weight: bold;">Nombre</p>
                                            </div>
                                            <?php echo $row['nombre'] ?>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <div>
                                                <label style="font-weight: bold;">Primer apellido</p>
                                            </div>
                                        <?php echo $row['apellido1'] ?></td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <div>
                                                <label style="font-weight: bold;">Segundo apellido</p>
                                            </div>
                                            <?php echo $row['apellido2'] ?>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <div>
                                                <label style="font-weight: bold;">Correo</p>
                                            </div>
                                            <?php echo $row['correo'] ?>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <div>
                                                <label style="font-weight: bold;">Calificar</p>
                                            </div>
                                            <table class="table table-borderless">
                                                <tbody>
                                                      <tr>
                                                           <a href="Controllers/calDoc.php?id=<?php echo $row['cedula'] ?>&cal=1">
                                                               <img src="https://img.icons8.com/color-glass/452/christmas-star.png" width="32" height="32" style="margin-left: 15px;margin-right: 15px;">
                                                           </a>
                                                      </tr>
                                                      <tr>
                                                           <a href="Controllers/calDoc.php?id=<?php echo $row['cedula'] ?>&cal=2">
                                                                <img src="https://img.icons8.com/color-glass/452/christmas-star.png" width="32" height="32" style="margin-left: 10px;margin-right: 10px;text-decoration: none !important;">
                                                           </a>
                                                      </tr>
                                                      <tr>
                                                           <a href="Controllers/calDoc.php?id=<?php echo $row['cedula'] ?>&cal=3">
                                                                 <img src="https://img.icons8.com/color-glass/452/christmas-star.png" width="32" height="32" style="margin-left: 10px;margin-right: 10px;text-decoration: none !important;">
                                                            </a>
                                                      </tr>
                                                      <tr>
                                                           <a href="Controllers/calDoc.php?id=<?php echo $row['cedula'] ?>&cal=4">
                                                                  <img src="https://img.icons8.com/color-glass/452/christmas-star.png" width="32" height="32" style="margin-left: 10px;margin-right: 10px;text-decoration: none !important;">
                                                           </a>
                                                      </tr>
                                                      <tr>
                                                           <a href="Controllers/calDoc.php?id=<?php echo $row['cedula'] ?>&cal=5">
                                                                   <img src="https://img.icons8.com/color-glass/452/christmas-star.png" width="32" height="32" style="margin-left: 10px;margin-right: 10px;text-decoration: none !important;">
                                                           </a>
                                                      </tr>
                                                </tbody>
                                            </table>
                                        </td>
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