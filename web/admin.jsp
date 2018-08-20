<%@page import="br.com.jsp.dao.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.jsp.bean.FuncionariosBean"%>
<%@page import="br.com.jsp.dao.CriadorDeComandosSQL.*"%>
<%@page import="br.com.jsp.bean.response.Resposta"%>

<%@page language="java" contentType="text/html; UTF-8"
	pageEncoding="UTF-8"%>
<link href="css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link href="css/estilos.css" rel="stylesheet">
<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bootstrap.js"></script>

<%@ include file="include/topo.jsp"%>
<%
	//Valida o nÃ­vel
	if (Integer.parseInt(String.valueOf(session.getAttribute("nivel"))) != 1) {
		response.sendRedirect("index.jsp");
	}
%>

<main>

<div>

	<!-- Nav tabs -->
	<ul class="nav nav-tabs" role="tablist">
		<li role="presentation" class="active"><a href="#cadastroDeItem"
			aria-controls="cadastroDeItem" role="tab" data-toggle="tab">Cadastro
				de Items</a></li>
		<li role="presentation"><a href="#itemsPerdidos"
			aria-controls="itemsPerdidos" role="tab" data-toggle="tab">Items
				Perdidos</a></li>
		<li role="presentation"><a href="#verAdministradores"
			aria-controls="verAdministradores" role="tab" data-toggle="tab">Administradores</a></li>
	</ul>

	<!-- Tab panes -->
	<div class="tab-content">

		<!--Aba dos itens-->
		<div role="tabpanel" class="tab-pane active" id="cadastroDeItem">
			<form class="formularioCadastro" action="cadastrarItem.jsp">
				<h1>
					<strong> Cadastro de Items </strong>
				</h1>
				<input type="text" placeholder="Codigo" class="inputs"
					name="cod_idItem"><br> <input type="text"
					placeholder="Nome" class="inputs" name="dad_nomeItem"><br>
				<input type="text" placeholder="Descrição" class="inputs"
					name="inf_descItem"><br> <input type="text"
					placeholder="Data*add mascara aqui" class="inputs"
					name="dat_perdidoItem"><br> <input type="text"
					placeholder="Disponibilidade*add checkbox" class="inputs"
					name="dad_dispItem"><br>

				<div class="container">
					<div class="col-md-6">
						<div class="form-group">
							<label>Upload Image</label>
							<div class="input-group">
								<span class="input-group-btn"> <span
									class="btn btn-default btn-file"> Browse… <input
										type="file" id="imgInp">
								</span>
								</span> <input type="text" class="form-control" readonly>
							</div>
							<img id='img-upload' />
						</div>
					</div>
				</div>

				<input type="text" placeholder="IdCliente" class="inputs"
					name="cod_idCliente"><br>
				<p>
				<center>
					<input type="submit" value="Cadastrar">
				</center>
				</p>
			</form>
		</div>

		<!--Aba de Busca-->
		<div role="tabpanel" class="tab-pane" id="itemsPerdidos">
			<h1>
				<h1>
					<strong> Items Perdidos </strong>
				</h1>

				<div>
					<busca> <form2 class="navbar-form navbar-left"
						role="search">
					<div class="form-group">
						<input type="text" placeholder="Local" id="botaoRedondo">
						<input type="text" placeholder="Objeto" id="botaoRedondo">


						<input type="text" class="js-date" maxlength="10"
							placeholder="__/__/____" />




					</div>
					<button type="submit" class="btn btn-default">Buscar</button>
					</form2> </busca>
				</div>
		</div>

		<!--Aba dos administradores-->
		<div role="tabpanel" class="tab-pane" id="verAdministradores">
			<h1>
				<strong> Administradores </strong>
				<div>
					<!-- Tabela -->
					<%
						Resposta<ArrayList<FuncionariosBean>> resposta = new GenericDao<FuncionariosBean>(FuncionariosBean.class)
								.selectAll();

						String estrutura;

						if (resposta.getFuncionou()) {

							estrutura = "<table class='table table-striped tabela'>";
							estrutura += "<tr>";
							estrutura += "<td><b>Login</b></td>";
							estrutura += "<td><b>Nome</b></td>";
							estrutura += "<td><b>IdEmpresa</b></td>";
							estrutura += "<td><b>Editar</b></td>";
							estrutura += "</tr>";

							ArrayList<FuncionariosBean> lista = resposta.getObjeto();

							for (FuncionariosBean funcionario : lista) {

								String ovo = "";
								ovo += session.getAttribute("id");
								int numero = Integer.parseInt(ovo);

								if (funcionario.getIdCliente() == numero) {

									estrutura += "<tr>";
									estrutura += "<td>" + funcionario.getLogin() + "</td>";
									estrutura += "<td>" + funcionario.getNome() + "</td>";
									estrutura += "<td>" + funcionario.getIdCliente() + "</td>";
									estrutura += "<td><a href='edicao.jsp?cod_idFuncionario=" + funcionario.getId()
											+ "'><span class='glyphicon glyphicon-pencil'></span></a></td>";
									estrutura += "</tr>";

								}

							}
						} else {
							estrutura = "<h1>Skidaddle skadoodle your dick is now a noodle</h1>";
						}

						out.print(estrutura);
					%>
				</div>
		</div>
	</div>

</div>

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