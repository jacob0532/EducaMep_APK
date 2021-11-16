<?php include("includes/db.php") ?>

<?php include("includes/header.php") ?>
	<div class="container p-4">
    <div class="row">
    	<div class="col">
        <h3>Agregar Curso</h3>	
		<form action="AgregarHorario.php" method="POST">
		  <div class="form-group m-3">
		    <label for="inputNombre">Nombre</label>
		    <input type="text" class="form-control" id="inputNombre" name="nombre" placeholder="Ciencias">
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
		  <button type="submit" class="btn btn-dark btn-lg m-4 ">Continuar</button>
		  <button type="button" onclick= "window.location.href ='GestionCurso.php'" class="btn btn-danger btn-lg m-4">Cancelar</button>     
		</form>
		</div>
	</div>
    </div>
<?php include("includes/footer.php") ?>