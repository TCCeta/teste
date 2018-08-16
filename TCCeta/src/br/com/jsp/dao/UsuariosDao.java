/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jsp.dao;

import br.com.jsp.bean.ItensDevolvidosBean;
import br.com.jsp.bean.UsuariosBean;
import br.com.jsp.bean.response.Resposta;
import br.com.jsp.dao.CriadorDeComandosSQL.GenericDao;
import br.com.jsp.dao.CriadorDeComandosSQL.Where;
import java.util.ArrayList;

/**
 *
 * @author 103782
 */
public class UsuariosDao {
 
    public static void insert(UsuariosBean usuario){
        
        new GenericDao<UsuariosBean>(UsuariosBean.class).insert(usuario);
        
    }
    
    public static void insert(ArrayList<UsuariosBean> usuarios){
        
        new GenericDao<UsuariosBean>(UsuariosBean.class).insert(usuarios);
        
    }
    
    public static void update(UsuariosBean usuario){
        
        new GenericDao<UsuariosBean>(UsuariosBean.class).update(usuario);
        
    }
    
    public static void update(ArrayList<UsuariosBean> usuarios){
        
        new GenericDao<UsuariosBean>(UsuariosBean.class).update(usuarios);
        
    }
    
    public static Resposta<ArrayList<UsuariosBean>> selectAll(){
        
        return new GenericDao<UsuariosBean>(UsuariosBean.class).selectAll();
        
    }
    
    public static Resposta<ArrayList<UsuariosBean>> selectWhere(String campo, Where comparacao, Object valor){
        
        return new GenericDao<UsuariosBean>(UsuariosBean.class).selectWhere(campo, comparacao, valor);
        
    }
    
}
