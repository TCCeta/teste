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
@Tabela(nome = "usuarios")
public class Usuario {

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the idConta
     */
    public int getIdConta() {
        return idConta;
    }

    /**
     * @param idConta the idConta to set
     */
    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }

    /**
     * @return the idLocal
     */
    public int getIdLocal() {
        return idLocal;
    }

    /**
     * @param idLocal the idLocal to set
     */
    public void setIdLocal(int idLocal) {
        this.idLocal = idLocal;
    }

    /**
     * @return the idPessoa
     */
    public int getIdPessoa() {
        return idPessoa;
    }

    /**
     * @param idPessoa the idPessoa to set
     */
    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }
    
    @Coluna(nome = "cod_idUsuario", tipo = Types.INTEGER, autoGerado = true, primaryKey = true)
    private int id;
    
    @Coluna(nome = "cod_idConta", tipo = Types.INTEGER)
    private int idConta;
    
    @Coluna(nome = "cod_idLocal", tipo = Types.INTEGER)
    private int idLocal;
    
    @Coluna(nome = "cod_idPessoa", tipo = Types.INTEGER)
    private int idPessoa;
    
}
