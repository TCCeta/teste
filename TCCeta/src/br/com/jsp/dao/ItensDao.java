/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jsp.dao;

import br.com.jsp.bean.ImagensBean;
import br.com.jsp.bean.ItensBean;
import br.com.jsp.bean.response.Resposta;
import br.com.jsp.dao.CriadorDeComandosSQL.GenericDao;
import br.com.jsp.dao.CriadorDeComandosSQL.Where;
import java.util.ArrayList;

/**
 *
 * @author 103782
 */
public class ItensDao {
    
    public static void insert(ItensBean item){
        
        new GenericDao<ItensBean>(ItensBean.class).insert(item);
        
    }
    
    public static void insert(ArrayList<ItensBean> itens){
        
        new GenericDao<ItensBean>(ItensBean.class).insert(itens);
        
    }
    
    public static void update(ItensBean item){
        
        new GenericDao<ItensBean>(ItensBean.class).update(item);
        
    }
    
    public static void update(ArrayList<ItensBean> itens){
        
        new GenericDao<ItensBean>(ItensBean.class).update(itens);
        
    }
    
    public static Resposta<ArrayList<ItensBean>> selectAll(){
        
        return new GenericDao<ItensBean>(ItensBean.class).selectAll();
        
    }
    
    public static Resposta<ArrayList<ItensBean>> selectWhere(String campo, Where comparacao, Object valor){
        
        return new GenericDao<ItensBean>(ItensBean.class).selectWhere(campo, comparacao, valor);
        
    }
    
}
