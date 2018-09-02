<%@page import="br.com.jsp.dao.UsuariosDao"%>
<%@page import="br.com.jsp.bean.FuncionariosBean"%>
<%@page import="br.com.jsp.dao.FuncionariosDao"%>
<%@page import="br.com.jsp.dao.CriadorDeComandosSQL.GenericDao"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="br.com.jsp.bean.UsuariosBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.jsp.dao.CriadorDeComandosSQL.*"%>
<%@page import="br.com.jsp.connector.ConnectionFactory"%>
<%@page import="br.com.jsp.bean.response.Resposta"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<link href="../css/bootstrap.min.css" rel="stylesheet">

<%

    //Obter o email e a senha
    String empresa = "";
    String email = request.getParameter("email");
    String senha = request.getParameter("senha");

    Class.forName("com.mysql.jdbc.Driver");
    
    Resposta<ArrayList<FuncionariosBean>> respostaF = FuncionariosDao.selectAll();

    Resposta<ArrayList<UsuariosBean>> respostaU = UsuariosDao.selectAll();

    if (!respostaF.getFuncionou() || !respostaU.getFuncionou()) {

        response.sendRedirect("../login.jsp?msg=falhaLogin");

    } else {

        boolean encontrou = false;

        for (FuncionariosBean funcionario : respostaF.getObjeto()) {
            if ((funcionario.getLogin().equals(email)) && (funcionario.getSenha().equals(senha))) {
                //fazer login de funcionario
                //Criar a sessão		
                session.setAttribute("sessaoUsuario", funcionario);
                session.setAttribute("nivel", 1);
                session.setAttribute("id", funcionario.getIdCliente());
                response.sendRedirect("../admin.jsp");

                encontrou = true;

            }
        }

        if (!encontrou) {
            for (UsuariosBean usuario : respostaU.getObjeto()) {

                if ((usuario.getLogin().equals(email)) && (usuario.getSenha().equals(senha))) {
                    //fazer login de usuario
                    //vai pra proxima pagina de usuario
                    session.setAttribute("sessaoUsuario", usuario);
                    session.setAttribute("nivel", 2);
                    encontrou = true;
                    response.sendRedirect("../buscar.jsp");
                    break;

                }
            }
        }

        if (!encontrou) {
            response.sendRedirect("../login.jsp?msg=falhaLogin");
        }
    }
%>