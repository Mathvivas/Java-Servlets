<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada" var="linkEntradaServlet"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Adicione Uma Empresa</title>
</head>
<body>

	<c:import url="logout-parcial.jsp"/>
	
	<!-- http://localhost:8080/gerenciador/novaEmpresa -->
	<!-- action: Para onde sera enviado o POST -->
	<form action="${ linkEntradaServlet }" method="post">
	
		Nome: <input type="text" name="nome" placeholder="Nome da Empresa">
		Data de Abertura: <input type="text" name="data">
		
		<input type="hidden" name="acao" value="NovaEmpresa">
		
		<input type="submit">
	
	</form>
	
</body>
</html>