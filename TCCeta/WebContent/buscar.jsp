<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- M�scara da Data -->
<script src="js/jquery.mask.js"></script>

<script type="text/javascript" src="js/jquery.mask.js"></script>

<script>
    $(document).ready(function () {

        $('.data').mask('00/00/0000', {placeholder: "__/__/____"});

    });
</script>


<%@ include file="include/topo.jsp"%>
<%
	//Valida o n�vel
	if (Integer.parseInt(String.valueOf(session.getAttribute("nivel"))) != 2) {
		response.sendRedirect("index.jsp");
	}
%>


<!-- Campos de busca -->
<main>
<div>
	<busca> <!--                    *******************************************************************-->
	<form2 class="navbar-form navbar-left" role="search">
	<div class="form-group">
		<input type="text" placeholder="Local" id="botaoRedondo"> <input
			type="text" placeholder="Objeto" id="botaoRedondo"> <input
			type="data" class="data" name="dat_perdidoItem">
	</div>
	<button type="submit" class="btn btn-default">Buscar</button>
	</form2> </busca>
</div>

<!-- Ordem dos Itens Encontrados --> </main>

<!-- Footer -->
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