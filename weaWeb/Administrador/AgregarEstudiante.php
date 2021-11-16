<?php include("includes/db.php") ?>

<?php include("includes/header.php") ?>
	<div class="container p-4">
    <div class="row">
    <h3>Agregar Estudiante</h3>	
    	<div class="col">
		<form action="scripts/insertarEstudiante.php" method="POST">
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
		  <div class="form-group m-3">
		    <label for="inputGrado">Grado</label>
		    <select class="form-control" id="inputGrado" name="grado">
		      <option>1 PRIMER GRADO</option>
		      <option>2 SEGUNDO GRADO</option>
		      <option>3 TERCER GRADO</option>
		      <option>4 CUARTO GRADO</option>
		      <option>5 QUINTO GRADO</option>
		      <option>6 SEXTO GRADO</option>
		      <option>7 SEPTIMO GRADO</option>
		      <option>8 OCTAVO GRADO</option>
		      <option>9 NOVENO GRADO</option>
		      <option>10 DECIMO GRADO</option>
		      <option>11 UNDECIMO GRADO</option>
		    </select>
		  </div>
		  <button type="submit" class="btn btn-dark btn-lg m-4 ">Aceptar</button>
		  <button type="button" onclick= "window.location.href ='GestionEstudiante.php'" class="btn btn-danger btn-lg m-4">Cancelar</button>
		</form>
		</div>
		</div>
    </div>

<?php include("includes/footer.php") ?>