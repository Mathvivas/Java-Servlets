<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada" var="linkEntradaServlet"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>

	<form action="${ linkEntradaServlet }" method="post">
	
		Login: <input type="text" name="login" placeholder="Usu�rio">
		Senha: <input type="password" name="senha" placeholder="Senha">
		
		<input type="hidden" name="acao" value="Login">
		
		<input type="submit">
	
	</form>
	
</body>
</html>