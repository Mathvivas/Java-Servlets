<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List, br.maua.gerenciador.servlets.Empresa" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Empresas</title>
</head>
<body>
		
	<ul>
		<c:forEach items="${ empresas }" var="empresa">
				<!-- empresa.getNome() -->
			<li>${ empresa.nome } - <fmt:formatDate value="${ empresa.dataAbertura }" 
				pattern="dd/MM/yyyy"/>
			</li>	
		</c:forEach>
	</ul>
		
</body>
</html>