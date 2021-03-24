<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List, br.maua.gerenciador.servlets.Empresa" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Empresas</title>
</head>
<body>
		
	<ul>
		<c:forEach items="${ empresas }" var="empresa">
			<li>${ empresa.nome }</li>			<!-- empresa.nome -->
		</c:forEach>
	</ul>
		
</body>
</html>