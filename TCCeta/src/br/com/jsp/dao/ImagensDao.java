/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jsp.dao;

import br.com.jsp.bean.FuncionariosBean;
import br.com.jsp.bean.ImagensBean;
import br.com.jsp.bean.response.Resposta;
import br.com.jsp.dao.CriadorDeComandosSQL.GenericDao;
import br.com.jsp.dao.CriadorDeComandosSQL.Where;
import java.util.ArrayList;

/**
 *
 * @author 103782
 */
public class ImagensDao {
    
    public static void insert(ImagensBean imagem){
        
        new GenericDao<ImagensBean>(ImagensBean.class).insert(imagem);
        
    }
    
    public static void insert(ArrayList<ImagensBean> imagens){
        
        new GenericDao<ImagensBean>(ImagensBean.class).insert(imagens);
        
    }
    
    public static void update(ImagensBean imagem){
        
        new GenericDao<ImagensBean>(ImagensBean.class).update(imagem);
        
    }
    
    public static void update(ArrayList<ImagensBean> imagens){
        
        new GenericDao<ImagensBean>(ImagensBean.class).update(imagens);
        
    }
    
    public static Resposta<ArrayList<ImagensBean>> selectAll(){
        
        return new GenericDao<ImagensBean>(ImagensBean.class).selectAll();
        
    }
    
    public static Resposta<ArrayList<ImagensBean>> selectWhere(String campo, Where comparacao, Object valor){
        
        return new GenericDao<ImagensBean>(ImagensBean.class).selectWhere(campo, comparacao, valor);
        
    }
    
}
