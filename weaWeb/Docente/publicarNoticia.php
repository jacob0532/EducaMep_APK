<?php include("includes/db.php") ?>

<?php include("includes/header.php") ?>
    
    <div class="container p-3">
        <div class="row">
            <div class="col col-lg-4">
                <div class="card card-body text-center">
                    <form action="">
                        <div class="mb-3">
                            <label for="title" class="form-label">Titulo de la noticia</label>
                            <input type="text" id="title" name="Titulo" class="form-control" placeholder="Titulo de la noticia" autofocus>
                        </div>
                        <div class="mb-3">
                            <label for="description" class="form-label">Descripcion de la noticia</label>
                            <textarea name="Descripcion" id="description" rows="10" class="form-control" placeholder="Descripcion de la notica"></textarea>
                        </div>
                        <input type="submit" class="btn btn-success btn-block" name="saveNews" value="Guardar Noticia">
                    </form>
                </div>

            </div>
            <div class="col-md-auto">
                
            </div>
        </div>
    </div>

<?php include("includes/footer.php") ?>