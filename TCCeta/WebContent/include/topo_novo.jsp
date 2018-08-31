<%@ page language="java" contentType="text/html; UTF-8"
	pageEncoding="UTF-8"%>

<!-- Incluir a verificação de sessão -->
<!DOCTYPE>
<html>
<head>

<!-- Bootstrap -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="../css/bootstrap.min.css" rel="stylesheet">
<script src="../js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>


<meta charse="UTF-8">
<title>What is missing</title>
</head>
<body>


	<%
		if (session.getAttribute("sessaoUsuario") == null) {
	%>

	<div class=bs-example data-example-id=inverted-navbar>
		<nav class="navbar navbar-inverse">
			<div class=container-fluid>
				<div class=navbar-header>
					<button type=button class="collapsed navbar-toggle"
						data-toggle=collapse data-target=#bs-example-navbar-collapse-9
						aria-expanded=false>
						<span class=sr-only>Toggle navigation</span> <span class=icon-bar></span>
						<span class=icon-bar></span> <span class=icon-bar></span>
					</button>
					<a href=# class=navbar-brand>What is Missing</a>
				</div>
				<div class="collapse navbar-collapse"
					id=bs-example-navbar-collapse-9>
					<ul class="nav navbar-nav">
						<li class=active><a href="index.jsp">Início</a></li>
						<li><a href="entrar.jsp">Login/Registre-se</a></li>
						<li><a href="sair.jsp">Sair</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</div>

	<%
		} else {
			if (Integer.parseInt(String.valueOf(session.getAttribute("nivel"))) == 0) {
	%>

	<div class=bs-example data-example-id=inverted-navbar>
		<nav class="navbar navbar-inverse">
			<div class=container-fluid>
				<div class=navbar-header>
					<button type=button class="collapsed navbar-toggle"
						data-toggle=collapse data-target=#bs-example-navbar-collapse-9
						aria-expanded=false>
						<span class=sr-only>Toggle navigation</span> <span class=icon-bar></span>
						<span class=icon-bar></span> <span class=icon-bar></span>
					</button>
					<a href=# class=navbar-brand>What is Missing</a>
				</div>
				<div class="collapse navbar-collapse"
					id=bs-example-navbar-collapse-9>
					<ul class="nav navbar-nav">
						<li class=active><a href="index.jsp">Início</a></li>
						<li><a href="entrar.jsp">Admin</a></li>
						<li><a href="sair.jsp">Sair</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</div>




	<%
		} else {
				if (Integer.parseInt(String.valueOf(session.getAttribute("nivel"))) == 2) {
	%>

	<div class=bs-example data-example-id=inverted-navbar>
		<nav class="navbar navbar-inverse">
			<div class=container-fluid>
				<div class=navbar-header>
					<button type=button class="collapsed navbar-toggle"
						data-toggle=collapse data-target=#bs-example-navbar-collapse-9
						aria-expanded=false>
						<span class=sr-only>Toggle navigation</span> <span class=icon-bar></span>
						<span class=icon-bar></span> <span class=icon-bar></span>
					</button>
					<a href=# class=navbar-brand>What is Missing</a>
				</div>
				<div class="collapse navbar-collapse"
					id=bs-example-navbar-collapse-9>
					<ul class="nav navbar-nav">
						<li class=active><a href="index.jsp">Início</a></li>
						<li><a href="entrar.jsp">Usuário</a></li>
						<li><a href="sair.jsp">Sair</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</div>


	<%
		}
			}
		}
	%>