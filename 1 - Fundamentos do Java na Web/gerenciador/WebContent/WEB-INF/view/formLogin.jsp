<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada" var="link1"/>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Login</title>
	</head>
	<body>
		<h1>Login de usuário</h1>
		<form action="${ link1 }" method="post">
			Login: <input type="text" name="login" />
			Senha: <input type="password" name="password" />
			<input type="hidden" name="action" value="Login" />
			<input type="submit" />
		</form>
	</body>
</html>