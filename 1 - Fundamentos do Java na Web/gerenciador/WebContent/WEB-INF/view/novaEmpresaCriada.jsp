<!-- < %
String nomeEmpresa = (String) request.getAttribute("empresa");
%> só é usado nos casos das linhas 9 e 10 -->

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<body>
		<c:if test="${ not empty empresa}">
			Empresa ${ empresa } cadastrada com sucesso!
			<!-- < %= nomeEmpresa %> serviria na linha acima -->
			<!-- < % out.print(nomeEmpresa); %> também serviria na linha acima -->
		</c:if>
		<c:if test="${ empty empresa}">
			Nenhuma empresa cadastrada.
		</c:if>
	</body>
</html>