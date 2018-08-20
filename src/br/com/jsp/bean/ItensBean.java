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
import java.time.LocalDateTime;
import javax.swing.text.DateFormatter;

/**
 *
 * @author 103782
 */
@Tabela(nome = "itens")
public class ItensBean {
    
    @Coluna(autoGerado = true,nome = "cod_idItem",primaryKey = true,tipo = Types.INTEGER)
    private int id;
    
    @Coluna(nome = "dad_nomeItem",tipo = Types.VARCHAR)
    private String nome;
    
    @Coluna(nome = "if_descItem",tipo = Types.VARCHAR)
    private String descricao;
    
    @Coluna(nome = "dat_perdidoItem",tipo = Types.DATE)
    private Date data;
    
    
    public LocalDate getData(){
        
        return data.toLocalDate();
        
    }
    
    @Coluna(nome = "dad_dispItem",tipo = Types.BOOLEAN)
    private boolean disponivel;
    
    
    
}
