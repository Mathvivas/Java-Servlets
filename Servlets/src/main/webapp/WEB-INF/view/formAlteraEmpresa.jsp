<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

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
	
		Nome: <input type="text" name="nome" placeholder="Nome da Empresa" 
			value="${ empresa.nome }" />
		Data de Abertura: <input type="text" name="data" 
			value="<fmt:formatDate value="${ empresa.dataAbertura }" pattern="dd/MM/yyyy"/>" />
			
		<!-- ID não pode ser mostrado, não pode ser alterado -->
		<input type="hidden" name="id" value="${ empresa.id }"/>
		
		<!-- A acão deve ser enviada para a Entrada -->
		<input type="hidden" name="acao" value="AlterarEmpresa"/>
		<input type="submit">
	
	</form>
	
</body>
</html>