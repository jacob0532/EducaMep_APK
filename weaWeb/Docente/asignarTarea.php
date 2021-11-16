<?php include("../db.php"); ?>

<?php include("includes/header.php"); ?>
    <?php if(verifyRightUser('Docente')){ 
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
            <div class="col col-lg-4">

                <?php if(isset($_SESSION['message'])){?>
                    <div class="alert alert-<?= $_SESSION['message_type'] ?> alert-dismissible fade show" role="alert">
                        <?= $_SESSION['message'] ?>
                        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                    </div>
                <?php unset($_SESSION['message']);
                      unset($_SESSION['message_type']);} ?>

                <div class="card card-body text-center">
                    <form action="Controllers/saveTarea.php" method="POST">
                        <div class="mb-3">
                            <label for="title" class="form-label">Titulo de la tarea</label>
                            <input type="text" id="title" name="titulo" class="form-control" placeholder="Titulo de la tarea" autofocus>
                        </div>

                        <div class="mb-3">
                            <label for="date" class="form-label">Fecha de entrega</label>
                            <input type="text" id="date" name="fechaE" class="form-control" placeholder="2012-12-20" autofocus>
                        </div>

                        <div class="mb-3">
                            <label for="description" class="form-label">Descripcion de la noticia</label>
                            <textarea id="description" name="descripcion" rows="10" class="form-control" placeholder="Descripcion de la notica"></textarea>
                        </div>
                        <input type="submit" class="btn btn-success btn-block" name="saveTarea" value="Guardar Tarea">
                    </form>
                </div>

            </div>
            <div class="col col-lg-8" style="padding-left:100px;">
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>Titulo</th>
                            <th>Descripcion</th>
                            <th>Fecha entrega</th>
                            <th>Fecha asignacion</th>
                        </tr>
                    </thead>
                    <tbody>
                        <?php
                            $idCurso = $_SESSION['idCurso'];
                            $query = "SELECT T.titulo as titulo, T.descripcion as descripcion, T.fechaEntrega as fechaE,T.fechaAsignacion as fechaA
                                        FROM Tarea T INNER JOIN Curso C ON C.idCurso=T.idCurso
                                        WHERE C.idCurso='$idCurso'";
                            $result = mysqli_query($conn, $query);

                            while($row = mysqli_fetch_array($result)){?>
                                <tr>
                                    <td><?php echo $row['titulo'] ?></td>
                                    <td><?php echo $row['descripcion'] ?></td>
                                    <td><?php echo $row['fechaE'] ?></td>
                                    <td><?php echo $row['fechaA'] ?></td>
                            <?php } 
                        ?>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
<?php } ?>
<?php include("includes/footer.php") ?>