<%
String nomeEmpresa = (String) request.getAttribute("empresa");
%>


<html>
	<body>
		Empresa <%= nomeEmpresa %> cadastrada com sucesso!
		<!-- <% out.print(nomeEmpresa); %> também serviria na linha acima -->
	</body>
</html>

<!-- Jakarta Server Pages (antigamente JavaServer Page) -> JSP -->