<?php

include("../../db.php");

require ("../../mail.php");
require("../../PDFLib/fpdf.php");
    $id = $_SESSION['idUser'];
    $idCurso = $_SESSION['idCurso'];
        
    $query = "SELECT correo FROM Docente WHERE (cedula = '$id')";
    $result = mysqli_query($conn, $query);
    // Mail
    $userMail = mysqli_fetch_array($result)['correo'];

    // Subject
    $query = "SELECT nombre FROM Curso WHERE (idCurso = '$idCurso')";
    $result = mysqli_query($conn, $query);
    $title = 'Lista de estudiantes del curso "' . mysqli_fetch_array($result)['nombre'] . '"';
    $subject = $title;
    
    // Pdf
    $pdf = new FPDF(); 
    $pdf->AddPage();
    $pdf->SetFont('Arial','B',12);
    $pdf->Cell(0, 10, $title,0,1, 'C');

    $width_cell=array(50,50,50,40);
    $pdf->SetFillColor(193,229,252);
    $pdf->Cell($width_cell[0],10,'Nombre',1,0,'C',true); // First header column 
    $pdf->Cell($width_cell[1],10,'Primer apellido',1,0,'C',true); // Second header column
    $pdf->Cell($width_cell[2],10,'Segundo apellido',1,0,'C',true); // Third header column 
    $pdf->Cell($width_cell[3],10,'Cedula',1,1,'C',true); // Fourth header column

    $pdf->SetFont('Arial','',10);
    $sql = "SELECT E.nombre as 'nombre', E.apellido1  as 'apellido1', E.apellido2 as 'apellido2', E.cedula as 'cedula'
                FROM Estudiante E INNER JOIN CursosEstudiantes CE ON CE.cedula=E.cedula
                WHERE (CE.idCurso='$idCurso' AND CE.periodo=(SELECT YEAR(NOW())) )";
    $query = mysqli_query($conn, $sql);
    if(mysqli_num_rows($query) > 0){
        while($row = mysqli_fetch_assoc($query)){
            $pdf->Cell($width_cell[0],10,$row['nombre'],    1,0,'C',false);
            $pdf->Cell($width_cell[1],10,$row['apellido1'], 1,0,'C',false); 
            $pdf->Cell($width_cell[2],10,$row['apellido2'], 1,0,'C',false); 
            $pdf->Cell($width_cell[3],10,$row['cedula'],    1,1,'C',false); 
        }
    }

    $fileName = 'ListaEstudiantes' . $idCurso . '.pdf';
    $attachment = $pdf->Output('S', $fileName);
    // Body
    $body = '<a> La lista de estudiantes que solicito </a>';

    sendMailWithPDF($subject, $body, $userMail, $attachment, $fileName);
    header("Location: ../listaEstudiantes.php");
?>