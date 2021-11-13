<?php include("../db.php") ?>

<?php include("includes/header.php") ?>
    <?php if(verifyRightUser('Administrador')){ 
        $_SESSION['message'] = 'Quedese en su interfaz >:c!';
        $_SESSION['message_type'] = 'danger';
        $typeUser = $_SESSION['typeUser'];
        header("Location: ../$typeUser/index.php");
    } else{ ?>
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
                    <?php echo 'nya'; ?>

                </div>
            </div>
        </div>
    <?php } ?>
<?php include("includes/footer.php") ?>