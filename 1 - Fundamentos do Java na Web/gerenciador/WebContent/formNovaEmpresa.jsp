<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada?criarEmpresa" var="linkServletNovaEmpresa"/>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Inserir Empresa</title>
	</head>
	<body>
		<form action="${ linkServletNovaEmpresa }" method="post">
			Nome: <input type="text" name="name" />
			Data: <input type="text" name="data" />
			<input type="hidden" name="action" value="criarEmpresa" />
			<input type="submit" />
		</form>
	</body>
</html>