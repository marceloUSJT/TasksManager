<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.Tarefas"%>
<%@ page import="service.TarefasService" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>TasksManager - Home</title>
	<link rel="stylesheet" href="../css/home.css">
	<link rel="stylesheet" href="../css/main.css">
</head>
<body>	
	<%
		HttpSession sessao = request.getSession();
		TarefasService service = new TarefasService();
		String email = sessao.getAttribute("email").toString();
		ArrayList<Tarefas> lista = service.listarTarefas(email);
	%>
	<header>
		<h1>TasksManager</h1>
		<ul>
			<li>
				Olá, <strong><%= sessao.getAttribute("nome") %></strong>
			</li>
			<li>
				<a href="login.jsp">Sair</a>
			</li>
		</ul>
	</header>
	<div id="containerCards">
	<a href="./criarTarefa.jsp" id="btnCriar">Criar Tarefa</a>
	<%
		for(int i = 0; i < lista.size(); i++){
	%>
			<div class="card">
				<div class="titulo">
					<h2><%= lista.get(i).getTitulo() %></h2>
					<ul>
						<li>
							<a href="./edit.jsp?id=<%=lista.get(i).getId()%>"><img src="../img/edit_icon.png"></a>
						</li>
						<li>
							<a href="../excluirTarefa.do?id=<%=lista.get(i).getId()%>"><img src="../img/delete_icon.png"></a>
						</li>
					</ul>
				</div>
				<div class="texto">
					<p><%= lista.get(i).getDescricao() %></p>
				</div>
			</div>
	<%
		}
	%>
	</div>
</body>
</html>