<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:url value="/entrada" var="linkEntradaServlet"/>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Editar Empresa</title>
	</head>
	<body>
		<c:import url="logoutParcial.jsp"/>
		<h1>Modificar empresa</h1>
		<form action="${ linkEntradaServlet }" method="post">
			Nome: <input type="text" name="name" value="${ nome }"/>
			Data: <input type="text" name="data" value="<fmt:formatDate value="${ data }" pattern="dd/MM/yyyy"/>"/>
			<input type="hidden" name="id" value="${ id }"/>
			<input type="hidden" name="action" value="ModificarEmpresa"/>
			<input type="submit" title="enviar"/>
		</form>
	</body>
</html>