<?php include("includes/db.php") ?>
<?php include("includes/header.php") ?>
    <div class="container p-3" style="height: 100%;display: flex;justify-content: center;align-items: center;">
        <div class="row">
            <div class="col col-lg-4">
                <form action="controller/asigDoc.php" method="POST">
                    <br></br>
                    <select name="id_docente" id="Docente" class="form-select" aria-label="Default select example">
                        <option selected>Docentes</option>
                        <?php
                            $query = "SELECT D.cedula as cedula, D.nombre as NombreD FROM Docente D";            
                            $result = mysqli_query($conn, $query);

                            while($row = mysqli_fetch_array($result)){
                                 echo '<option value="'.$row['cedula'].'">'.$row['cedula'].'-'.$row['NombreD'].'</option>';
                            } 
                        ?>
                    </select>
                    <br></br>
                    <select name="id_curso" id="Curso" class="form-select" aria-label="Default select example">
                        <option selected>Cursos</option>
                        <?php
                            $query = "SELECT C.idCurso as idCurso, C.nombre as NombreC FROM Curso C";            
                            $result = mysqli_query($conn, $query);

                            while($row = mysqli_fetch_array($result)){
                                 echo '<option value="'.$row['idCurso'].'">'.$row['idCurso'].'-'.$row['NombreC'].'</option>';
                            } 
                        ?>
                    </select>
                    <br></br>
                    <input type="submit" class="btn btn-success btn-block" name="actualizar" value="Ver Cursos">
                    <input type="submit" class="btn btn-success btn-block" name="AsignarDoc" value="Asignar">
                    <input type="submit" class="btn btn-success btn-block" name="EliminarDoc" value="Borrar">
                </form>            
            </div>
            <div class="col col-lg-8" style="padding-left:100px;">
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>ID Curso</th>
                            <th>Nombre Curso</th>
                            <th>Grado</th>
                            <th>Cedula</th>
                            <th>Nombre Docente</th>
                            <th>Primer apellido</th>
                            <th>Segundo apellido</th>
                        </tr>
                    </thead>
                    <tbody>
                        <?php
                            $cedula = $_SESSION['id_docenteTabla'];
                            $query = "SELECT C.idCurso as idCurso, C.nombre as NombreC, C.grado as Grado, D.cedula as cedula, D.nombre as NombreD, D.apellido1  as apell1, D.apellido2 as apell2
                                        FROM Curso C INNER JOIN CursosDocente CD ON C.idCurso = CD.idCurso
                                                    INNER JOIN Docente D on CD.cedula=D.cedula
                                        WHERE CD.cedula='$cedula' AND CD.periodo=(SELECT YEAR(NOW()))";            
                            $result = mysqli_query($conn, $query);
                            unset($_SESSION['id_docenteTabla']);
                            while($row = mysqli_fetch_array($result)){?>
                                <tr>
                                    <td><?php echo $row['idCurso'] ?></td>
                                    <td><?php echo $row['NombreC'] ?></td>
                                    <td><?php echo $row['Grado'] ?></td>
                                    <td><?php echo $row['cedula'] ?></td>
                                    <td><?php echo $row['NombreD'] ?></td>
                                    <td><?php echo $row['apell1'] ?></td>
                                    <td><?php echo $row['apell2'] ?></td>
                                </tr>
                            <?php } 
                        ?>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
<?php include("includes/footer.php") ?>