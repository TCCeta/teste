
import br.com.jsp.bean.FuncionariosBean;
import br.com.jsp.bean.UsuariosBean;
import br.com.jsp.bean.response.Resposta;
import br.com.jsp.dao.FuncionariosDao;
import br.com.jsp.dao.UsuariosDao;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author patri
 */
public class main {

    public static void main(String[] args) {
        Resposta<ArrayList<FuncionariosBean>> respostaF = FuncionariosDao.selectAll();

        Resposta<ArrayList<UsuariosBean>> respostaU = UsuariosDao.selectAll();

        if (!respostaF.getFuncionou() || !respostaU.getFuncionou()) {

            //response.sendRedirect("../login.jsp?msg=falhaLogin");
            System.out.println("falha no login");
            
        } else {

            boolean encontrou = false;

            for (FuncionariosBean funcionario : respostaF.getObjeto()) {
                if ((funcionario.getLogin().equals("maicon")) && (funcionario.getSenha().equals("123"))) {
                    //fazer login de funcionario
                    //Criar a sessão		
                    /*session.setAttribute("sessaoUsuario", funcionario);
                    session.setAttribute("nivel", 1);
                    session.setAttribute("id", funcionario.getIdCliente());
                    encontrou = true;
                    response.sendRedirect("../admin.jsp");
                    break;*/
                    System.out.println("entrou como maicon");
                }
            }

            if (!encontrou) {
                for (UsuariosBean usuario : respostaU.getObjeto()) {

                    if ((usuario.getLogin().equals("haha")) && (usuario.getSenha().equals("yes"))) {
                        //fazer login de usuario
                        //vai pra proxima pagina de usuario
                        /*session.setAttribute("sessaoUsuario", usuario);
                        session.setAttribute("nivel", 2);
                        encontrou = true;
                        response.sendRedirect("../buscar.jsp");
                        break;*/

                    }
                }
            }

            if (!encontrou) {
                //response.sendRedirect("../login.jsp?msg=falhaLogin");
            }
        }

    }
}
