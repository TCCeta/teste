
<%@ include file="include/topo_V2.jsp"%>
<link href="css/bootstrap.min.css" rel="stylesheet">
<%
	if (session.getAttribute("sessaoUsuario") == null) {
%>
<main>

<div>
	<form class="formularioLogin" action="acoes/logar.jsp">
		<h1>
			<center>Login</center>
		</h1>
		<p>
		<center>
			<input type="text" placeholder="E-mail" class="inputs" name="email">
		</center>
		</p>
		<p>
		<center>
			<input type="password" placeholder="Senha" class="inputs"
				name="senha">
		</center>
		</p>
		<p>
		<center>
			<input type="submit" value="Entrar">
		</center>
		</p>
		<p>
		<center>
			N�o tem login?<br>Fa�a seu login <a href="#">aqui</a>
		</center>
		</p>
	</form>
</div>

</main>

<section>
	<footer>
		<p>Copyright What is Missing 2018 | Todos os direitos reservados</p>
		<a><img src="imagens\redesSociais\facebook.jpg"></a> <a><img
			src="imagens\redesSociais\twitter.jpg"></a> <a><img
			src="imagens\redesSociais\google.jpg"></a>

	</footer>
</section>

</body>

</html>
<%
	} else {
%>

<main>

<div>
	<form class="formularioLogin" action="acoes/logar.jsp">
		<h1>
			<center>Voc� j� fez login</center>
		</h1>
		<p><center>Voltar para a <a href="index.jsp">home</a><center></center></p>
	</form>
</div>

</main>

<section>
	<footer>
		<p>Copyright What is Missing 2018 | Todos os direitos reservados</p>
		<a><img src="imagens\redesSociais\facebook.jpg"></a> 
                <a><img src="imagens\redesSociais\twitter.jpg"></a> 
                <a><img src="imagens\redesSociais\google.jpg"></a>

	</footer>
</section>

</body>

</html>

<%
	}
%>