<%@page import="javax.swing.JOptionPane"%>
<%@page import="br.com.jsp.bean.UsuariosBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.jsp.dao.GenericDao"%>
<%@page import="br.com.jsp.bean.FuncionariosBean"%>
<%@page import="br.com.jsp.connector.ConnectionFactory"%>
<%@page import="br.com.jsp.bean.response.Resposta"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link href="../css/bootstrap.min.css" rel="stylesheet">

<%
	//Obter o email e a senha
	String empresa="";
	String email = request.getParameter("email");
	String senha = request.getParameter("senha");

	//Instanciar um objeto bean
	FuncionariosBean ub = new FuncionariosBean();

	out.print("haha yes");

	Resposta<ArrayList<FuncionariosBean>> respostaF = new GenericDao<FuncionariosBean>(FuncionariosBean.class)
			.selectAll();

	Resposta<ArrayList<UsuariosBean>> respostaU = new GenericDao<UsuariosBean>(UsuariosBean.class).selectAll();

	if (!respostaF.getFuncionou() || !respostaU.getFuncionou()) {

		response.sendRedirect("../login.jsp?msg=falhaLogin");

	} else {

		ArrayList<FuncionariosBean> listaFuncionarios = new GenericDao<FuncionariosBean>(FuncionariosBean.class)
				.selectAll().getObjeto();

		ArrayList<UsuariosBean> listaUsuarios = new GenericDao<UsuariosBean>(UsuariosBean.class).selectAll()
				.getObjeto();

		boolean encontrou = false;

		for (FuncionariosBean funcionario : listaFuncionarios) {
			if ((funcionario.getLogin().equals(email)) && (funcionario.getSenha().equals(senha))) {
				//fazer login de funcionario
				//Criar a sessão		
				session.setAttribute("sessaoUsuario", ub);
				session.setAttribute("nivel", 1);
				response.sendRedirect("../admin.jsp");
				
				encontrou = true;
			}
		}

		for (UsuariosBean usuario : listaUsuarios) {

			if ((usuario.getLogin().equals(email)) && (usuario.getSenha().equals(senha))) {
				//fazer login de usuario
				//vai pra proxima pagina de usuario
				session.setAttribute("sessaoUsuario", ub);
				session.setAttribute("nivel", 2);
				response.sendRedirect("../buscar.jsp");
				encontrou = true;
			}
		}

		out.print("haha yes");

		if (!encontrou) {
			response.sendRedirect("../login.jsp?msg=falhaLogin");
		}
	}
%>