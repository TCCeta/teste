/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jsp.dao;

import br.com.jsp.bean.ClientesBean;
import br.com.jsp.bean.FuncionariosBean;
import br.com.jsp.bean.VendasBean;
import br.com.jsp.bean.response.Resposta;
import br.com.jsp.dao.CriadorDeComandosSQL.GenericDao;
import br.com.jsp.dao.CriadorDeComandosSQL.Where;
import java.util.ArrayList;

/**
 *
 * @author 103782
 */
public class ClientesDao {
    
    public static void insert(ClientesBean cliente){
        
        new GenericDao<ClientesBean>(ClientesBean.class).insert(cliente);
        
    }
    
    public static void insert(ArrayList<ClientesBean> cliente){
        
        new GenericDao<ClientesBean>(ClientesBean.class).insert(cliente);
        
    }
    
    public static void update(ClientesBean cliente){
        
        new GenericDao<ClientesBean>(ClientesBean.class).update(cliente);
        
    }
    
    public static void update(ArrayList<ClientesBean> cliente){
        
        new GenericDao<ClientesBean>(ClientesBean.class).update(cliente);
        
    }
    
    public static Resposta<ArrayList<ClientesBean>> selectAll(){
        
        return new GenericDao<ClientesBean>(ClientesBean.class).selectAll();
        
    }
    
    public static Resposta<ArrayList<ClientesBean>> selectWhere(String campo, Where comparacao, Object valor){
        
        return new GenericDao<ClientesBean>(ClientesBean.class).selectWhere(campo, comparacao, valor);
        
    }
    
}
