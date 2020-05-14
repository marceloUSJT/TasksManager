<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TasksManager - Criar</title>
<link rel="stylesheet" href="../css/main.css"/>
<link rel="stylesheet" href="../css/login.css"/>
</head>
<body>
	<%
		HttpSession sessao = request.getSession();
		String email = sessao.getAttribute("email").toString();
	%>
	<div id="container">
		<h1>Criar</h1>
		<form action="../criarTarefa.do" method="POST">
			<div class='formItem'>
				<label>Titulo: <input type='text' placeholder='Insira o titulo' name='titulo'></label>
			</div>
			<div class='formItem'>
				<label>Descrição: <textarea name="descricao" placeholder="Insira aqui a descrição"></textarea></label>
			</div>
			<input type="hidden" name="emailUsuario" value="<%=email%>">
			<div class='formItem'>
				<input type='submit' value='Criar' id='btnEnviar'>
			</div>
		</form>
	</div>
</body>
</html>