/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jsp.dao;

import br.com.jsp.bean.UsuariosBean;
import br.com.jsp.bean.VendasBean;
import br.com.jsp.bean.response.Resposta;
import br.com.jsp.dao.CriadorDeComandosSQL.GenericDao;
import br.com.jsp.dao.CriadorDeComandosSQL.Where;
import java.util.ArrayList;

/**
 *
 * @author 103782
 */
public class VendasDao {
    
    public static void insert(VendasBean venda){
        
        new GenericDao<VendasBean>(VendasBean.class).insert(venda);
        
    }
    
    public static void insert(ArrayList<VendasBean> venda){
        
        new GenericDao<VendasBean>(VendasBean.class).insert(venda);
        
    }
    
    public static void update(VendasBean venda){
        
        new GenericDao<VendasBean>(VendasBean.class).update(venda);
        
    }
    
    public static void update(ArrayList<VendasBean> venda){
        
        new GenericDao<VendasBean>(VendasBean.class).update(venda);
        
    }
    
    public static Resposta<ArrayList<VendasBean>> selectAll(){
        
        return new GenericDao<VendasBean>(VendasBean.class).selectAll();
        
    }
    
    public static Resposta<ArrayList<VendasBean>> selectWhere(String campo, Where comparacao, Object valor){
        
        return new GenericDao<VendasBean>(VendasBean.class).selectWhere(campo, comparacao, valor);
        
    }
    
}
