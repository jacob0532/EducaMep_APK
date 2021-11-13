<?php include("../db.php") ?>

<?php include("includes/header.php") ?>
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
                                <th>Cursos</th>
                            </tr>
                        </thead>
                        <tbody>
                            <?php
                                //'$cedula'
                                $query = "SELECT C.idCurso as id, C.nombre as nombre, C.grado as grado
                                            FROM Curso C INNER JOIN CursosDocente CD ON C.idCurso = CD.idCurso
                                            WHERE CD.cedula=123 AND CD.periodo=(SELECT YEAR(NOW()))";
                                $result = mysqli_query($conn, $query);

                                while($row = mysqli_fetch_array($result)){?>
                                    <tr>
                                        <td><?php echo $row['nombre'] ?></td>
                                        <td><?php echo $row['grado'] ?></td>
                                        <td>
                                            <?php if(!isset($_SESSION['idCurso']) or $_SESSION['idCurso']!=$row['id']){?>
                                                <a href="Controllers/selCurso.php?id=<?php echo $row['id'] ?>">
                                                    <img src="https://img.icons8.com/small/452/unchecked-checkbox.png" width="16" height="16">
                                                </a>
                                            <?php }else{ ?>
                                                <a href="Controllers/selCurso.php?id=<?php echo $row['id'] ?>">
                                                    <img src="https://img.icons8.com/small/452/checked-checkbox.png" width="16" height="16">
                                                </a>
                                            <?php }?>
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
<?php include("includes/footer.php") ?>