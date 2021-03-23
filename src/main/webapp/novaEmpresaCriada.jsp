<%
// scriplet jsp : java server page
String nomeEmpresa = (String) request.getAttribute("empresa");
%>

<html>

	<body>
	
		Empresa <% out.println(nomeEmpresa); %> Cadastrada com sucesso!
		<!-- Empresa <%= nomeEmpresa %> Cadastrada com sucesso! -->
	
	</body>

</html>