<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/novaEmpresa" var="linkServletNovaEmpresa"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Adicione Uma Empresa</title>
</head>
<body>
	
	<!-- http://localhost:8080/gerenciador/novaEmpresa -->
	<!-- action: Para onde sera enviado o POST -->
	<form action="${ linkServletNovaEmpresa }" method="post">
	
		Nome: <input type="text" name="nome" placeholder="Nome da Empresa">
		Data de Abertura: <input type="text" name="data">
		
		<input type="submit">
	
	</form>
	
</body>
</html>