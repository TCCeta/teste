<%@ include file="include/topo_novo_com_sessao.jsp"%>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/jquery.mask.js"></script>
<script type="text/javascript" src="js/jquery.mask.js"></script>
<script>
	$(document).ready(function() {

		$('.cpf').mask('000.000.000-00', {placeholder : "___.___.___-__"});

	});
</script>
<main>

<div>
	<form class="formularioCadastroUsuario" action="acoes/cadastrarUser.jsp">
		<h1>
			<center>Cadastro</center>
		</h1>
		<p>
		<center>
			<input type="text" placeholder="Nome" class="inputs">
		</p>
		<p>
			<input type="text" placeholder="Usuário" class="inputs">
		</p>
		<p>
			<input type="text" class="cpf" id="inputs" name="dat_cpfUsuario">
		</p>
		<p>
			<input type="password" placeholder="Senha" class="inputs">
		</p>
		<p>
			<input type="submit" value="Cadastrar">
		</center>
		</p>
	</form>
</div>

</main>

<%@ include file="include/rodape.jsp"%>


</body>

</html>
