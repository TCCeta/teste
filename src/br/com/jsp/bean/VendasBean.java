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
@Tabela(nome = "vendas")
public class VendasBean {

    @Coluna(autoGerado = true, nome = "cod_idVenda", primaryKey = true, tipo = Types.INTEGER)
    private int id;

    @Coluna(nome = "cod_idCliente", tipo = Types.INTEGER)
    private int idCliente;
    private ClientesBean cliente;

    @Coluna(nome = "dad_validadeLicensa", tipo = Types.DATE)
    private Date validadeLicensa;
    
    public LocalDate getDataValidadeLicensa(){
        return validadeLicensa.toLocalDate();
    }

    @Coluna(nome = "dad_dataVenda", tipo = Types.DATE)
    private Date dataVendas;
    
    public LocalDate getDataVenda(){
        return dataVendas.toLocalDate();
    }

}
