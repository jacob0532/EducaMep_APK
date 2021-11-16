<?php include("includes/db.php") ?>

<?php include("includes/header.php") ?>

<?php 
$cedula= $_GET['cedula']; 
$nombre = $_GET['nombre'];
$apellido1 = $_GET['apellido1']; 
$apellido2 = $_GET['apellido2']; 
$correo = $_GET['correo']; 

?>

<div class="container p-4">
    <div class="row">
    <h3>Modificar Docente</h3>	
    	<div class="col">
		<form action="scripts/actualizarDocuente.php" method="POST">
		  <div class="form-group m-3">
		    <label for="inputCedula">Cedula : <?php echo "{$cedula}";?> </label>
		    <input type="number" class="form-control" id="inputCedula" name="cedula" value="<?php echo "{$cedula}";?>" hidden>
		  </div>
		  <div class="form-group m-3">
		    <label for="inputNombre">Nombre</label>
		    <input type="text" class="form-control" id="inputNombre" name="nombre" value="<?php echo "{$nombre}";?>">
		  </div>
		  <div class="form-group m-3">
		    <label for="inputApellido1">Apellido1</label>
		    <input type="text" class="form-control" id="inputApellido1" name="apellido1" value="<?php echo "{$apellido1}";?>">
		  </div>
		  <div class="form-group m-3">
		    <label for="inputApellido2">Apellido2</label>
		    <input type="text" class="form-control" id="inputApellido2" name="apellido2" value="<?php echo "{$apellido2}";?>">
		  </div>
		  <div class="form-group m-3">
		    <label for="inputCorreo">Correo electronico</label>
		    <input type="email" class="form-control" id="inputCorreo" name="correo" value="<?php echo "{$correo}";?>">
		  </div>
		  <button type="submit" class="btn btn-dark btn-lg m-4 ">Actualizar</button>
		  <button type="button" onclick= "window.location.href ='GestionDocente.php'" class="btn btn-danger btn-lg m-4">Cancelar</button>
		</form>
		</div>
		</div>
    </div>
<?php include("includes/footer.php") ?>