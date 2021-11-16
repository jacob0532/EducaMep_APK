<?php include("includes/db.php") ?>

<?php include("includes/header.php") ?>

<?php
if (isset($_SESSION['cursoAdmin'])){
    $idCurso = $_SESSION['cursoAdmin'];
    $nombre = $_SESSION['nombreAdmin'];
    unset($_SESSION['cursoAdmin']);
    unset($_SESSION['nombreAdmin']);
}
else{
    $idCurso= $_GET['idCurso'];
    $nombre = $_GET['nombre'];  
} 
?>




<div class="container p-4">
    <div class="row">
    	<div class="col">
        <h3>ModificarCurso Curso</h3>	
		<form action="scripts/actualizarCurso.php" method="POST">
        <button type="submit" class="btn btn-dark btn-lg m-4 ">Actualizar curso</button>
		  <button type="button" onclick= "window.location.href ='GestionCurso.php'" class="btn btn-danger btn-lg m-4">Cancelar</button>   
          <div class="form-group m-3">
		    <label for="inputIdCurso">idCurso: <?php echo "{$idCurso}";?></label>
		    <input type="number" class="form-control" id="inputIdCurso" name="idCurso" value="<?php echo "{$idCurso}";?>" hidden>
		  </div>

		  <div class="form-group m-3">
		    <label for="inputNombre">Nombre</label>
		    <input type="text" class="form-control" id="inputNombre" name="nombre" value="<?php echo "{$nombre}";?>">
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
		</form>
		</div>
	</div>
    <div class="row">
    <h3>Horario</h3>
			<form action="scripts/crearHorario2.php?idCurso=<?php echo "{$idCurso}"; ?>&nombre=<?php echo "{$nombre}"; ?> " method="POST">
				<div class="form-group m-3">
				    <label for="inputDia">Dia</label>
				    <select class="form-control" id="inputDia" name="dia">
				      <option>Lunes</option>
				      <option>Martes</option>
				      <option>Miercoles</option>
				      <option>Jueves</option>
				      <option>Viernes</option>
				      <option>Sabado</option>
				      <option>Domingo</option>
				    </select>
				  </div> 
				  <div class="row"> 
				  <div class="col">
				  	<div class="form-group m-3">
				    <label for="inputHoraInicial">Hora de inicio</label>
				    <select class="form-control" id="inputHoraInicial" name="horaInicio">
				      <option><time>7:00</time></option>
				      <option><time>8:00</time></option>
				      <option><time>9:00</time></option>
				      <option><time>10:00</time></option>
				      <option><time>11:00</time></option>
				      <option><time>12:00</time></option>
				      <option><time>13:00</time></option>
				    </select>
				  </div> 
				  </div>
				  <div class="col">
				  	<div class="form-group m-3">
				    <label for="inputHoraFinal">Hora de finalizacion</label>
				    <select class="form-control" id="inputHoraFinal" name="horaFinal">
				      <option><time>7:00</time></option>
				      <option><time>8:00</time></option>
				      <option><time>9:00</time></option>
				      <option><time>10:00</time></option>
				      <option><time>11:00</time></option>
				      <option><time>12:00</time></option>
				      <option><time>13:00</time></option>
				    </select>
				  </div> 
				  </div>
				  </div>
                  <button type="submit" class="btn btn-dark btn-lg m-2">Agregar</button>
			</form>

			<table class="table text-center table-success table-striped table-borderless table-sm m-2">
			  <thead>
			    <tr>
				  <th>IdCurso</th>
			      <th>Dia</th>
			      <th>Hora Inicial</th>
			      <th>Hora Final</th>
			    </tr>
			  </thead>
			  <tbody>
            <?php
				if (isset($_SESSION['idHorarioAdmin'])){
					$query3 = "DELETE FROM Horario WHERE idHorario='{$_SESSION['idHorarioAdmin']}'";
					mysqli_query($conn, $query3);
					unset($_SESSION['idHorarioAdmin']);
				}
                $query2 = "SELECT idHorario,idCurso,dia,horaInicio,horaFinal FROM Horario WHERE idCurso = '{$idCurso}'";
                $resultado2 = mysqli_query($conn, $query2);
                while($consulta2 = mysqli_fetch_array($resultado2)){
					echo "<tr>
							<td>{$consulta2['idCurso']}</td>
							<td>{$consulta2['dia']}</td>
							<td>{$consulta2['horaInicio']}</td>
							<td>{$consulta2['horaFinal']}</td>";?>
							<td> 
								<form action='EliminarHorario.php?idCurso=<?php echo "{$idCurso}"; ?>&nombre=<?php echo "{$nombre}"; ?>' method='POST'>
									<input type='text' class='idHorario' name='idHorario' value='<?php echo "{$consulta2['idHorario']}";?>' hidden></input>
									<button type='submit' name='enviarHorario2' class='btn btn-primary'>X</button>
								</form>
							</td>
						</tr>
						<?php
                }
            ?>
			  </tbody>
			</table>
    </div>
    </div>
    
<?php include("includes/footer.php") ?>