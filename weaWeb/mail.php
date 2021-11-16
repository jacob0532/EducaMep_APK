<?php
function sendMail(String $subject, string $body, string $gmail){
    require 'PHPMailer/PHPMailerAutoload.php';
	$mail=new PHPMailer();
	//indico a la clase que use SMTP
	$mail->IsSMTP();
	//permite modo debug para ver mensajes de las cosas que van ocurriendo
	//$mail>SMTPDebug = 2;

	//indico el servidor de Gmail para SMTP
	$mail->Host='smtp.gmail.com';

	//indico el puerto que usa Gmail
	$mail->Port=587;

	//Debo de hacer autenticaci&#65533;n SMTP
	$mail->SMTPAuth=true;
	$mail->SMTPSecure='tls';

	//indico un usuario / clave de un usuario de gmail
	$mail->Username='soporteeducamep@gmail.com';
	$mail->Password='JJK-Group2021';

	$mail->SetFrom('soporteeducamep@gmail.com', 'Soporte EducaMEP');
	$mail->AddAddress($gmail);
	$mail->AddReplyTo('soporteeducamep@gmail.com', 'Soporte EducaMEP');

	$mail->isHTML(true);
	$mail->Subject=$subject;
	$mail->Body=$body;


	if(!$mail->Send()) {
		echo 'Error al enviar: ' . $mail->ErrorInfo;
	} else {
		echo 'Mensaje enviado!';
	}
}

function sendMailWithPDF(String $subject, string $body, string $gmail, string $pdf, string $filename){
    require 'PHPMailer/PHPMailerAutoload.php';
	$mail=new PHPMailer();
	//indico a la clase que use SMTP
	$mail->IsSMTP();
	//permite modo debug para ver mensajes de las cosas que van ocurriendo
	//$mail>SMTPDebug = 2;

	//indico el servidor de Gmail para SMTP
	$mail->Host='smtp.gmail.com';

	//indico el puerto que usa Gmail
	$mail->Port=587;

	//Debo de hacer autenticaci&#65533;n SMTP
	$mail->SMTPAuth=true;
	$mail->SMTPSecure='tls';

	//indico un usuario / clave de un usuario de gmail
	$mail->Username='soporteeducamep@gmail.com';
	$mail->Password='JJK-Group2021';

	$mail->SetFrom('soporteeducamep@gmail.com', 'Soporte EducaMEP');
	$mail->AddAddress($gmail);
	$mail->AddReplyTo('soporteeducamep@gmail.com', 'Soporte EducaMEP');

	$mail->isHTML(true);
	$mail->Subject=$subject;
	$mail->Body=$body;
	$mail->AddStringAttachment($pdf, $filename);

	if(!$mail->Send()) {
		echo 'Error al enviar: ' . $mail->ErrorInfo;
	} else {
		echo 'Mensaje enviado!';
	}
}
?>