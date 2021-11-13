<?php include("db.php") ?>

<?php include("includes/header.php") ?>
    <div class="container p-3" style="height: 100%;display: flex;justify-content: center;align-items: center;">
        <div class="row">
            <div class="col-md-auto">
                <?php if(isset($_SESSION['message'])){?>
                    <div class="alert alert-<?= $_SESSION['message_type'] ?> alert-dismissible fade show" role="alert">
                        <?= $_SESSION['message'] ?>
                        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                    </div>
                <?php unset($_SESSION['message']);
                      unset($_SESSION['message_type']);} ?>

                <div class="card card-body text-center">
                    <form action="Includes/verifyLogin.php" method="POST">
                        <div class="mb-3">
                            <label for="username" class="form-label">Usuario</label>
                            <input type="text" id="username" name="username" class="form-control" placeholder="exampe@example.com" autofocus>
                        </div>

                        <div class="mb-3">
                            <label for="password" class="form-label">Contraseña</label>
                            <input type="password" id="password" name="password" class="form-control">
                        </div>
                        <?php if($_GET['type'] == 'adm'){ ?>
                            <input type="submit" class="btn btn-success btn-block" name="loginAdmin" value="Login">
                        <?php } ?>
                        <?php if($_GET['type'] == 'doc'){ ?>
                            <input type="submit" class="btn btn-success btn-block" name="loginDocente" value="Login">
                        <?php } ?>
                        <?php if($_GET['type'] == 'est'){ ?>
                            <input type="submit" class="btn btn-success btn-block" name="loginEstudiante" value="Login">
                        <?php } ?>
                    </form>
                </div>
            </div>
        </div>
    </div>
<?php include("includes/footer.php") ?>