<%@ page language="java" contentType="text/html; UTF-8"
	pageEncoding="UTF-8"%>

<!-- Incluir a verificação de sessão -->
<%@ include file="sessao.jsp"%>
<!DOCTYPE>
<html>
<head>

<!-- Bootstrap -->
<link href="../css/bootstrap.min.css" rel="stylesheet">
<script src="../js/bootstrap.min.js"></script>

<meta charse="UTF-8">
<title>What is missing</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>

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
	