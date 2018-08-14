<link href="css/bootstrap.min.css" rel="stylesheet">

<%
	//Limpar a sessão
	session.setAttribute("sessaoUsuario", null);


	//Redirecionamento
	response.sendRedirect("index.jsp?msg=saida");
%>