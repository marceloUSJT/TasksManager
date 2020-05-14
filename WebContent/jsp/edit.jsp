<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="service.TarefasService" %>
<%@ page import="model.Tarefas" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>TaskManager - Editar</title>
	<link rel="stylesheet" href="../css/login.css">
	<link rel="stylesheet" href="../css/main.css">
</head>
<body>
	<div id="container">
	<%
		int id = Integer.parseInt(request.getParameter("id"));
		TarefasService service = new TarefasService();
		Tarefas tarefa = service.consultar(id);
	%>
		<h1>Editar</h1>
		<form action="../editarTarefa.do" action="POST">
			<div class='formItem'>
				<label>Titulo: <input type='text' value="<%= tarefa.getTitulo() %>" placeholder='Insira o titulo' name='titulo'></label>
			</div>
			<div class='formItem'>
				<label>Descrição: <textarea name="descricao" placeholder="Insira aqui a descrição"><%= tarefa.getDescricao() %></textarea></label>
				<input type='hidden' value='<%=id%>' name="id">
			</div>
			<div class='formItem'>
				<input type='submit' value='Editar' id='btnEnviar'>
			</div>
		</form>
	</div>
</body>
</html>