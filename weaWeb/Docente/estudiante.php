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
                <div class="card card-body text-center">
                    <table class="table table-bordered" style="width:500px">
                        <thead>
                            <tr>
                                <th>Estudiante</th>
                            </tr>
                        </thead>
                        <?php if (isset($_SESSION['data'])){?>
                            <tbody>
                                <tr>
                                    <td>
                                        <div>
                                            <label style="font-weight: bold;">Cedula</p>
                                        </div>
                                        <label><?php echo $_SESSION['data']['cedula'] ?></label>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div>
                                            <label style="font-weight: bold;">Nombre</p>
                                        </div>
                                        <?php echo $_SESSION['data']['nombre'] ?>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div>
                                            <label style="font-weight: bold;">Primer apellido</p>
                                        </div>
                                    <?php echo $_SESSION['data']['apellido1'] ?></td>
                                </tr>
                                <tr>
                                    <td>
                                        <div>
                                            <label style="font-weight: bold;">Segundo apellido</p>
                                        </div>
                                        <?php echo $_SESSION['data']['apellido2'] ?>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div>
                                            <label style="font-weight: bold;">Correo</p>
                                        </div>
                                        <?php echo $_SESSION['data']['correo'] ?>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div>
                                            <label style="font-weight: bold;">Grado</p>
                                        </div>
                                        <?php echo $_SESSION['data']['grado'] ?>
                                    </td>
                                </tr>
                            </tbody>
                        <?php unset($_SESSION['data']);}?>
                    </table>
                </div>
            </div>
        </div>
    </div>
<?php } ?>
<?php include("includes/footer.php") ?>