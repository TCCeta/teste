/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jsp.bean;

import br.com.jsp.bean.Annotations.Coluna;
import br.com.jsp.bean.Annotations.Tabela;
import java.sql.Types;

/**
 *
 * @author 103782
 */
@Tabela(nome = "imagens")
public class ImagensBean {
    
    @Coluna(nome = "cod_idImagem", tipo = Types.INTEGER, autoGerado = true, primaryKey = true)
    private int id;
    
    @Coluna(nome = "dad_nomeImagem", tipo = Types.VARCHAR)
    private String caminho;
    
    @Coluna(nome = "cod_idCliente", tipo = Types.INTEGER)
    private int idCliente;
    private ClientesBean cliente;
    
    
}
