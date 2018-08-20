/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jsp.dao;

import br.com.jsp.bean.ClientesBean;
import br.com.jsp.bean.FuncionariosBean;
import br.com.jsp.bean.response.Resposta;
import br.com.jsp.dao.CriadorDeComandosSQL.GenericDao;
import br.com.jsp.dao.CriadorDeComandosSQL.Where;
import java.util.ArrayList;

/**
 *
 * @author 103782
 */
public class FuncionariosDao {
    
    public static void insert(FuncionariosBean funcionario){
        
        new GenericDao<FuncionariosBean>(FuncionariosBean.class).insert(funcionario);
        
    }
    
    public static void insert(ArrayList<FuncionariosBean> funcionarios){
        
        new GenericDao<FuncionariosBean>(FuncionariosBean.class).insert(funcionarios);
        
    }
    
    public static void update(FuncionariosBean funcionario){
        
        new GenericDao<FuncionariosBean>(FuncionariosBean.class).update(funcionario);
        
    }
    
    public static void update(ArrayList<FuncionariosBean> funcionarios){
        
        new GenericDao<FuncionariosBean>(FuncionariosBean.class).update(funcionarios);
        
    }
    
    public static Resposta<ArrayList<FuncionariosBean>> selectAll(){
        
        return new GenericDao<FuncionariosBean>(FuncionariosBean.class).selectAll();
        
    }
    
    public static Resposta<ArrayList<FuncionariosBean>> selectWhere(String campo, Where comparacao, Object valor){
        
        return new GenericDao<FuncionariosBean>(FuncionariosBean.class).selectWhere(campo, comparacao, valor);
        
    }
    
}
