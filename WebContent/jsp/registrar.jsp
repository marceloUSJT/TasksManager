<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TaskManager Register</title>
<link rel="stylesheet" href="../css/main.css"/>
<link rel="stylesheet" href="../css/login.css">
</head>
<body>
	<div id="container">
		<h1>REGISTRE-SE</h1>
		<form action='../CadastrarUsuario.do' method='POST'>
			<div class='formItem'>
				<label>Email: <input type='email' placeholder='Insira seu email' name='email'></label>
			</div>
			<div class='formItem'>
				<label>Nome: <input type='text' placeholder='Insira seu nome' name='nome'></label>
			</div>
			<div class='formItem'>
				<label>Senha: <input type='password' placeholder='Insira sua senha' name='senha'></label>
			</div>
			<div class='formItem'>
				<input type='submit' value='Registrar' id='btnEnviar'>
			</div>
		</form>
	</div>
</body>
</html>