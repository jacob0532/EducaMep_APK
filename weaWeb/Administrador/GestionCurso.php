<?php include("../db.php") ?>

<?php include("includes/header.php") ?>
    
    <div class="container p-3" style="height: 100%;display: flex;justify-content: center;align-items: center;">
        <div class="row">
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
                        $query = "SELECT `titulo`, `texto`, `fecha` FROM noticia";
                        $result = mysqli_query($conn, $query);

                        while($row = mysqli_fetch_array($result)){?>
                            <tr>
                                <td><?php echo $row['titulo'] ?></td>
                                <td><?php echo $row['texto'] ?></td>
                                <td><?php echo $row['fecha'] ?></td>
    
                    <?php } ?>
                </tbody>
            </table>
        </div>
    </div>

<?php include("includes/footer.php") ?>