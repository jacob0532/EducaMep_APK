<?php include("includes/db.php") ?>

<?php include("includes/header.php") ?>

<?php
if(isset($_POST['nombre'])){
	$nombre= $_POST['nombre'];
    $grado= $_POST['grado'];
   

    if( empty($nombre) or empty($grado)){
        header("Location: GestionCurso.php" );
    }

    $query = "INSERT INTO Curso (nombre,grado) VALUES ('$nombre','$grado')";

    if(!mysqli_query($conn, $query)){ //si no hubo query devuelvase sino siga...
        header("Location: GestionCurso.php" );
    } 

}
?>

<h3>Horario</h3>
			<form action="scripts/crearHorario.php" method="POST">
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
                  <button type="submit" class="btn btn-dark btn-lg m-2">Agregar horario</button>
				  <button type="button" onclick= "window.location.href ='GestionCurso.php'" class="btn btn-dark btn-lg m-2">Finalizar</button>
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
                $query2 = "SELECT idHorario,idCurso,dia,horaInicio,horaFinal FROM Horario WHERE idCurso = (SELECT MAX(idCurso) FROM Curso)";
                $resultado2 = mysqli_query($conn, $query2);
                while($consulta2 = mysqli_fetch_array($resultado2)){
					echo "<tr>
							<td>{$consulta2['idCurso']}</td>
							<td>{$consulta2['dia']}</td>
							<td>{$consulta2['horaInicio']}</td>
							<td>{$consulta2['horaFinal']}</td>";?>
							<td> 
								<form action='EliminarHorario.php' method='POST'>
									<input type='text' class='idHorario' name='idHorario' value='<?php echo "{$consulta2['idHorario']}";?>' hidden></input>
									<button type='submit' name='enviarHorario' class='btn btn-primary'>X</button>
								</form>
							</td>
						</tr>
						<?php
                }
            ?>
			  </tbody>
			</table>
<?php include("includes/footer.php") ?>

        