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
            <div class="col col-lg-4">

                <?php if(isset($_SESSION['message'])){?>
                    <div class="alert alert-<?= $_SESSION['message_type'] ?> alert-dismissible fade show" role="alert">
                        <?= $_SESSION['message'] ?>
                        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                    </div>
                <?php unset($_SESSION['message']);
                      unset($_SESSION['message_type']);} ?>

                <div class="card card-body text-center">
                    <form action="Controllers/saveNoticia.php" method="POST">
                        <div class="mb-3">
                            <label for="title" class="form-label">Titulo de la noticia</label>
                            <input type="text" id="title" name="titulo" class="form-control" placeholder="Titulo de la noticia" autofocus>
                        </div>
                        <div class="mb-3">
                            <label for="description" class="form-label">Descripcion de la noticia</label>
                            <textarea name="descripcion" id="description" rows="10" class="form-control" placeholder="Descripcion de la notica"></textarea>
                        </div>
                        <input type="submit" class="btn btn-success btn-block" name="saveNews" value="Guardar Noticia">
                    </form>
                </div>

            </div>
            <div class="col col-lg-8" style="padding-left:100px;">
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>Titulo</th>
                            <th>Descripcion</th>
                            <th>Fecha</th>
                        </tr>
                    </thead>
                    <tbody>
                        <?php
                            $idCurso = $_SESSION['idCurso'];
                            $query = "SELECT N.titulo as titulo, N.texto as texto, N.fecha as fecha
                                        FROM Noticia N INNER JOIN Curso C ON C.idCurso=N.idCurso
                                        WHERE C.idCurso='$idCurso'";
                            $result = mysqli_query($conn, $query);

                            while($row = mysqli_fetch_array($result)){?>
                                <tr>
                                    <td><?php echo $row['titulo'] ?></td>
                                    <td><?php echo $row['texto'] ?></td>
                                    <td><?php echo $row['fecha'] ?></td>
                            <?php } 
                        ?>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
<?php } ?>
<?php include("includes/footer.php") ?>