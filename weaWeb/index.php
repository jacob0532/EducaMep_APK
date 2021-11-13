<?php include("db.php") ?>

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
                    <div>
                        <h1 class="display-3">Bienvenido a EducaMEP</h1>
                    </div>
                    <div>
                        <a href="login.php?type=adm" class="btn btn-info" style="width: 50%;margin-top: 15px;">Login administrador</a>
                    </div>
                    <div>
                        <a href="login.php?type=doc" class="btn btn-info" style="width: 50%;margin-top: 15px;">Login docente</a>
                    </div>
                    <div>
                        <a href="login.php?type=est" class="btn btn-info" style="width: 50%;margin-top: 15px;">Login estudiante</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
<?php include("includes/footer.php") ?>