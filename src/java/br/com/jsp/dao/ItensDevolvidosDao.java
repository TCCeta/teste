/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jsp.dao;

import br.com.jsp.bean.ItensBean;
import br.com.jsp.bean.ItensDevolvidosBean;
import br.com.jsp.bean.response.Resposta;
import br.com.jsp.dao.CriadorDeComandosSQL.GenericDao;
import br.com.jsp.dao.CriadorDeComandosSQL.Where;
import java.util.ArrayList;

/**
 *
 * @author 103782
 */
public class ItensDevolvidosDao {
    
    public static void insert(ItensDevolvidosBean item){
        
        new GenericDao<ItensDevolvidosBean>(ItensDevolvidosBean.class).insert(item);
        
    }
    
    public static void insert(ArrayList<ItensDevolvidosBean> itens){
        
        new GenericDao<ItensDevolvidosBean>(ItensDevolvidosBean.class).insert(itens);
        
    }
    
    public static void update(ItensDevolvidosBean item){
        
        new GenericDao<ItensDevolvidosBean>(ItensDevolvidosBean.class).update(item);
        
    }
    
    public static void update(ArrayList<ItensDevolvidosBean> itens){
        
        new GenericDao<ItensDevolvidosBean>(ItensDevolvidosBean.class).update(itens);
        
    }
    
    public static Resposta<ArrayList<ItensDevolvidosBean>> selectAll(){
        
        return new GenericDao<ItensDevolvidosBean>(ItensDevolvidosBean.class).selectAll();
        
    }
    
    public static Resposta<ArrayList<ItensDevolvidosBean>> selectWhere(String campo, Where comparacao, Object valor){
        
        return new GenericDao<ItensDevolvidosBean>(ItensDevolvidosBean.class).selectWhere(campo, comparacao, valor);
        
    }
    
}

