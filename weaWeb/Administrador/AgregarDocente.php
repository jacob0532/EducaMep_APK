<?php include("includes/db.php") ?>

<?php include("includes/header.php") ?>
	<div class="container p-4">
    <div class="row">
    <h3>Agregar Docente</h3>	
    	<div class="col">
		<form action="scripts/insertarDocente.php" method="POST">
		  <div class="form-group m-3">
		    <label for="inputCedula">Cedula</label>
		    <input type="number" class="form-control" id="inputCedula" name="cedula" placeholder="12345678">
		  </div>
		  <div class="form-group m-3">
		    <label for="inputNombre">Nombre</label>
		    <input type="text" class="form-control" id="inputNombre" name="nombre" placeholder="Caballero Juan">
		  </div>
		  <div class="form-group m-3">
		    <label for="inputApellido1">Apellido1</label>
		    <input type="text" class="form-control" id="inputApellido1" name="apellido1" placeholder="Calderon">
		  </div>
		  <div class="form-group m-3">
		    <label for="inputApellido2">Apellido2</label>
		    <input type="text" class="form-control" id="inputApellido2" name="apellido2" placeholder="Solano">
		  </div>
		  <div class="form-group m-3">
		    <label for="inputCorreo">Correo electronico</label>
		    <input type="email" class="form-control" id="inputCorreo" name="correo" placeholder="nombre@example.com">
		  </div>
			  <button type="submit" class="btn btn-dark btn-lg m-4 ">Aceptar</button>
			  <button type="button" onclick= "window.location.href ='GestionDocente.php'" class="btn btn-danger btn-lg m-4">Cancelar</button>
				     
		</form>
		</div>
		</div>
    </div>
<?php include("includes/footer.php") ?>