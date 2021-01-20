<!DOCTYPE html>

<%@ page import="java.util.List, br.com.alura.gerenciador.servlet.Empresa" %>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Empresas</title>
	</head>
	<body>
		<h1>Empresas cadastradas</h1>
			<ul>
			<%
				List<Empresa> empresas = (List<Empresa>) request.getAttribute("empresas");
				for (Empresa empresa : empresas) {
			%>
			<li><%= empresa.getNome() %></li>
			<%
				}
			%>
			</ul>
	</body>
</html>