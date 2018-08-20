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
@Tabela(nome = "clientes")
public class ClientesBean {
    
    private static int numero = 1;
    
    @Coluna(nome = "cod_idCliente", tipo = Types.INTEGER, autoGerado = true, primaryKey = true)
    private int id;
    
    @Coluna(nome = "loc_enderecoCliente", tipo = Types.VARCHAR)
    private String endereco;
    
    @Coluna(nome = "dad_nomeCliente", tipo = Types.VARCHAR)
    private String nome;
    
    public ClientesBean(String endereco, String nome){
        
        this.endereco = endereco;
        this.nome = nome;
        this.id = numero;
        numero++;
        
    }
    
    public int getNumero(){
        return this.numero;
    }
    
}
