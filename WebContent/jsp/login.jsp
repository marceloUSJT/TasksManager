<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TaskManager Login</title>
<link rel="stylesheet" href="../css/main.css"/>
<link rel="stylesheet" href="../css/login.css"/>
</head>
<body>
	<div id="container">
		<h1>LOGIN</h1>
		<form action='../Login.do' method='POST'>
			<div class='formItem'>
				<%
					HttpSession sessao = request.getSession();
					if(sessao.getAttribute("mensagem") != null){
				 	out.println(sessao.getAttribute("mensagem"));
					sessao.removeAttribute("mensagem");
					}
				%>
			</div>
			<div class='formItem'>
				<label>Email: <input type='email' placeholder='Insira seu email' name='email'></label>
			</div>
			<div class='formItem'>
				<label>Senha: <input type='password' placeholder='Insira sua senha' name='senha'></label>
			</div>
			<div class='formItem'>
				<input type='submit' value='Entrar' id='btnEnviar'>
			</div>
			<div class='formItem'>
				<a href='registrar.jsp'>Registre-se</a>
			</div>
		</form>
	</div>
</body>
</html>