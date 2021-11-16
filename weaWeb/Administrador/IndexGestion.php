<?php include("includes/db.php") ?>

<?php include("includes/header.php") ?>

<div class="d-flex justify-content-center text-center">
<div style="background-image: url('https://www.silicon.es/wp-content/uploads/2015/07/Fuente-Shutterstock_Autor-FabioBalbi_educacion-estudiar-1280x720.jpg');height: 700px;width:1280px;">

<div class="row m-5">
<div class="d-flex justify-content-center">
<button type="button" onclick= "window.location.href ='GestionCurso.php'" class="btn btn-primary btn-lg">  GestiÃ³n de Cursos  </button>
</div>
</div>
<div class="row m-5">
<div class="d-flex justify-content-center">
<button type="button" onclick= "window.location.href ='GestionDocente.php'" class="btn btn-primary btn-lg">  GestiÃ³n de Docentes  </button>
</div>
</div>
<div class="row m-5">
<div class="d-flex justify-content-center">
<button type="button" onclick= "window.location.href ='GestionEstudiante.php'" class="btn btn-primary btn-lg">  GestiÃ³n de Estudiantes  </button>
</div>
</div>
<div class="row m-5">
<div class="d-flex justify-content-center">
<button type="button" onclick= "window.location.href ='asignarEstudiante.php'" class="btn btn-primary btn-lg">  Asignación Cursos Est  </button>
</div>
</div>
<div class="row m-5">
<div class="d-flex justify-content-center">
<button type="button" onclick= "window.location.href ='asignarDocente.php'" class="btn btn-primary btn-lg">  Asignación Cursos Doc </button>
</div>
</div>
</div>
</div>
<?php include("includes/footer.php") ?>