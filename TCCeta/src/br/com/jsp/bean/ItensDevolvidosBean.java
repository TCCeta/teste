/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jsp.bean;

import br.com.jsp.bean.Annotations.Coluna;
import br.com.jsp.bean.Annotations.Tabela;
import java.sql.Date;
import java.sql.Types;
import java.time.LocalDate;

/**
 *
 * @author 103782
 */
@Tabela(nome = "itensDevolvidos")
public class ItensDevolvidosBean {
    
    @Coluna(autoGerado = true,nome = "cod_idItemDev",primaryKey = true,tipo = Types.INTEGER)
    private int id;
    
    @Coluna(nome = "cod_idItem",tipo = Types.INTEGER)
    private int idItem;
    private ItensBean item;
    
    @Coluna(nome = "cod_idFuncionario",tipo = Types.INTEGER)
    private int idFunconario;
    private FuncionariosBean funcionario;
    
    @Coluna(nome = "dat_entregaItemDev",tipo = Types.DATE)
    private Date dataDeEntrega;
    
    public LocalDate getDataDeEntrega(){
        
        return dataDeEntrega.toLocalDate();
        
    }
    
    @Coluna(nome = "cod_idUsuario",tipo = Types.INTEGER)
    private int idUsuario;
    private UsuariosBean usuario;
    
}
