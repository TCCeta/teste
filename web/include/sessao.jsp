<link href="../css/bootstrap.min.css" rel="stylesheet">

<%
	//Verificar se h� sess�o usu�rio
	if (session.getAttribute("sessaoUsuario") == null) {
		response.sendRedirect("index.jsp");
	}

	

%>