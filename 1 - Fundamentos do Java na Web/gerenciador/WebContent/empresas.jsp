<%@ page import="java.util.List, br.com.alura.gerenciador.servlet.Empresa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Empresas</title>
	</head>
	<body>
		<h1>Empresas cadastradas</h1>
		<fmt:setLocale value="pt_BR" />
		<ul>
			<c:forEach items="${ empresas }" var="empresa">
				<li>${empresa.nome} - <fmt:formatDate value="${ empresa.dataAbertura }" pattern="dd/MM/yyyy"/>
				(<a href="/gerenciador/modificaEmpresa?id=${empresa.id}">Editar</a> | <a href="/gerenciador/removeEmpresa?id=${empresa.id}"> Remover</a>) 
				</li>
			</c:forEach>
		</ul>
	</body>
</html>