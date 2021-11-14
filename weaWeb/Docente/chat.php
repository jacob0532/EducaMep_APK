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
        <div class="container p-3" style="width: 100%;height: 100%;display: flex;justify-content: center;align-items: center;">
            <div class="row">
                <div class="col-md-auto">
                    <div class="wrapper">
                        <section class="chat-area">
                        <header>
                            <?php 
                                $id = $_SESSION['idUser'];
                                $query = "SELECT * FROM `Docente` WHERE cedula='$id'";
                                $result = mysqli_query($conn, $query);
                                if(mysqli_num_rows($result)>0){
                                    $row = mysqli_fetch_array($result);
                                    $nombre = $row['nombre'];
                                }
                            ?>
                            <div class="details">
                                <span><?php echo $row['nombre'] . " " . $row['apellido1'] . " " . $row['apellido2']; ?></span>
                            </div>
                        </header>
                        <div class="chat-box">

                        </div>
                        <form action="#" class="typing-area">
                            <input type="text" class="nombreUser" name="nombreUser" value="<?php echo $nombre ?>" hidden>
                            <input type="text" class="idCurso" name="idCurso" value="<?php echo $_SESSION['idCurso']?>" hidden>
                            <input type="text" name="message" class="input-field" placeholder="Escriba mensaje aqui..." autocomplete="off">
                            <button></button>
                        </form>
                        </section>
                    </div>
                    <script src="Controllers/chat.js"></script>
                </div>
            </div>
        </div>
    <?php } ?>
    
<?php include("includes/footer.php") ?>