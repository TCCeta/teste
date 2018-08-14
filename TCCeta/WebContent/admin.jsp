<%@page import="java.util.ArrayList"%>
<%@page import="br.com.jsp.bean.FuncionariosBean"%>
<%@page import="br.com.jsp.dao.GenericDao"%>
<%@page import="br.com.jsp.bean.response.Resposta"%>
<link href="css/bootstrap.min.css" rel="stylesheet">

<%@ include file="include/topo.jsp"%>


<main> <!-- Tabela --> <%
 	Resposta<ArrayList<FuncionariosBean>> resposta = new GenericDao<FuncionariosBean>(FuncionariosBean.class)
 			.select();

 	String estrutura;

 	if (resposta.getFuncionou()) {

 		estrutura = "<table class='table table-striped tabela'>";
 	 	estrutura += "<tr>";
 	 	estrutura += "<td>Login</td>";
 	 	estrutura += "<td>Nome</td>";
 	 	estrutura += "<td>Editar</td>";
 	 	estrutura += "<td>Excluir</td>";
 	 	estrutura += "</tr>";
 		
 		ArrayList<FuncionariosBean> lista = resposta.getObjeto();

 		for (FuncionariosBean funcionario : lista) {

 			estrutura += "<tr>";
			estrutura += "<td>" + funcionario.getLogin() + "</td>";
			estrutura += "<td>" + funcionario.getNome() + "</td>";
			estrutura += "<td><a href='edicao.jsp?cod_idFuncionario=" + funcionario.getId()
					+ "'><span class='glyphicon glyphicon-pencil'></span></a></td>";
			estrutura += "<td><a href='acoes/excluir.jsp?cod_idFuncionario=" + funcionario.getId()
					+ "'><span class='glyphicon glyphicon-trash'></span></a></td>";
			estrutura += "</tr>";
 			
 		}

 	} else {
 		estrutura = "<h1>Skidaddle skadoodle your dick is now a noodle</h1>";
 	}
 	
 	out.print(estrutura);
 	
 %> </main>

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