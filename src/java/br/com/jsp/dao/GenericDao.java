/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jsp.dao;

import br.com.jsp.connector.ConnectionFactory;
import br.com.jsp.bean.Annotations.Tabela;
import br.com.jsp.bean.Annotations.Coluna;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;


/**
 * Classe genérica para criação de comandos SQL
 * @author patrick
 * @param <T> Tipo de dado a ser Usado nos comandos
 */
public class GenericDao<T> {

    final String nomeBanco = "tcceta";
    
    final Class<T> typeClass;

    /**
     * Construtor 
     * @param clazz Classe.class a ser usada nos comandos
     */
    public GenericDao(Class<T> clazz) {
        typeClass = clazz;
    }

    /**
     * Gerador de comandos INSERT para um só Objeto
     * @param obj Objeto a ser inserido
     */
    public void insert(T obj) {

        //Prepara uma ArrayList
        ArrayList<Field> fieldsUsados = new ArrayList<>();

        if (typeClass.isAnnotationPresent(Tabela.class)) {

            Tabela tab = (Tabela) typeClass.getAnnotation(Tabela.class);

            String sql = "";

            sql = "INSERT INTO " + tab.nome() + " (";

            for (Field field : typeClass.getDeclaredFields()) {

                if (field.isAnnotationPresent(Coluna.class)) {

                    fieldsUsados.add(field);
                    Coluna col = (Coluna) field.getAnnotation(Coluna.class);

                    sql += col.nome() + ",";

                }

            }

            sql = sql.substring(0, sql.length() - 1) + ") VALUES (";

            for (Field fieldsUsado : fieldsUsados) {

                sql += "?,";

            }

            sql = sql.substring(0, sql.length() - 1) + ")";

            try {

                Connection conexao = new ConnectionFactory(nomeBanco).obterConexao();

                PreparedStatement pstmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

                for (int i = 0; i < fieldsUsados.size(); i++) {

                    Field field = fieldsUsados.get(i);

                    Coluna col = field.getAnnotation(Coluna.class);

                    boolean wasAccessible = field.isAccessible();
                    if (!wasAccessible) {
                        field.setAccessible(true);
                    }

                    if (col.autoGerado()) {

                        pstmt.setNull(i + 1, col.tipo());

                    } else if (col.tipo() == Types.BLOB) {

                        pstmt.setBlob(i + 1, (Blob) field.get(obj));

                    } else {

                        pstmt.setObject(i + 1, field.get(obj), col.tipo());

                    }

                    if (!wasAccessible) {
                        field.setAccessible(false);
                    }

                }

                System.out.println(pstmt);

                pstmt.execute();
                
                pstmt.close();

            } catch (Exception e) {

                System.out.println(e.getMessage());

            }

        } else {

        }
    }

    /**
     * Gerador de comandos INSERT para uma ArrayList de Objetos
     * @param lista a Lista de objetos a ser inserida
     */
    public void insert(ArrayList<T> lista) {

        ArrayList<Field> fieldsUsados = new ArrayList<>();

        if (typeClass.isAnnotationPresent(Tabela.class)) {

            Tabela ann = (Tabela) typeClass.getAnnotation(Tabela.class);

            String sql = "";

            sql = "INSERT INTO " + ann.nome() + " (";

            for (Field field : typeClass.getDeclaredFields()) {

                if (field.isAnnotationPresent(Coluna.class)) {

                    fieldsUsados.add(field);
                    Coluna col = (Coluna) field.getAnnotation(Coluna.class);

                    sql += col.nome() + ",";

                }

            }

            sql = sql.substring(0, sql.length() - 1) + ") VALUES";

            for (Object object : lista) {

                sql += "(";

                for (Field fieldsUsado : fieldsUsados) {

                    sql += "?,";

                }

                sql = sql.substring(0, sql.length() - 1) + "),";

            }
            sql = sql.substring(0, sql.length() - 1);

            int idx = 0;

            try {

                Connection conexao = new ConnectionFactory(nomeBanco).obterConexao();

                PreparedStatement pstmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

                for (T t : lista) {

                    for (Field field : fieldsUsados) {

                        Coluna col = field.getAnnotation(Coluna.class);

                        boolean wasAccessible = field.isAccessible();
                        if (!wasAccessible) {
                            field.setAccessible(true);
                        }

                        if (col.autoGerado()) {

                            pstmt.setNull(idx + 1, col.tipo());

                        } else if (col.tipo() == Types.BLOB) {

                            pstmt.setBlob(idx + 1, (Blob) field.get(t));

                        } else {

                            pstmt.setObject(idx + 1, field.get(t), col.tipo());

                        }

                        idx++;

                    }

                }

                System.out.println(pstmt);

                pstmt.execute();
                pstmt.close();

            } catch (Exception e) {
            }

        }
    }

    /**
     * Gerador de comandos UPDATE para um único objeto, irá mudar no banco o item que
     * tiver o ID do objeto
     * @param obj Objeto a receber Update
     */
    public void update(T obj) {

        String sql = "";

        if (typeClass.isAnnotationPresent(Tabela.class)) {

            Tabela tab = (Tabela) typeClass.getAnnotation(Tabela.class);

            sql = "UPDATE " + tab.nome() + " SET ";

            ArrayList<Field> fieldsUsados = new ArrayList<>();

            Field primaryField = null;

            for (Field field : typeClass.getDeclaredFields()) {

                if (field.isAnnotationPresent(Coluna.class)) {

                    Coluna col = field.getAnnotation(Coluna.class);

                    if (!col.autoGerado()) {

                        fieldsUsados.add(field);
                        sql += col.nome() + " = ?,";

                    } else if (col.primaryKey()) {

                        primaryField = field;

                    }

                }

            }

            sql = sql.substring(0, sql.length() - 1) + " WHERE " + primaryField.getAnnotation(Coluna.class).nome() + " = ?";

            System.out.println(sql);

            try {

                Connection conexao = new ConnectionFactory(nomeBanco).obterConexao(); //botar o banco certo

                PreparedStatement pstmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

                for (int i = 0; i < fieldsUsados.size(); i++) {

                    Field field = fieldsUsados.get(i);

                    Coluna col = field.getAnnotation(Coluna.class);

                    int index = i + 1;

                    Boolean wasActive = field.isAccessible();
                    if(!wasActive){
                        field.setAccessible(true);
                    }
                    
                    if (col.primaryKey()) {
                        index = fieldsUsados.size() + 1;

                        pstmt.setNull(index, col.tipo());

                    } else if (col.tipo() == Types.BLOB) {

                        pstmt.setBlob(index, (Blob) field.get(obj));

                    } else {
                        pstmt.setObject(index, field.get(obj), col.tipo());
                    }
                    
                    if(!wasActive){
                        field.setAccessible(false);
                    }

                }

                boolean wasAccessible = primaryField.isAccessible();
                if(!wasAccessible){
                    primaryField.setAccessible(true);
                }
                
                pstmt.setObject(fieldsUsados.size() + 1, primaryField.get(obj) ,primaryField.getAnnotation(Coluna.class).tipo());

                if(!wasAccessible){
                    primaryField.setAccessible(false);
                }
                
                System.out.println(pstmt);
                
                pstmt.execute();
                pstmt.close();

            } catch (Exception e) {

                System.out.println("erro : " + e.getMessage());

            }

        } else {
            System.out.println("Esta classe não tem @Tabela");
        }

    }

    /**
     * Gerador de comandos UPDATE para uma lista de objetos, irá mudar no banco os item que
     * tiverem os IDs dos objetos na lista
     * @param lista
     */
    public void update(ArrayList<T> lista) {

        String sql = "";

        if (typeClass.isAnnotationPresent(Tabela.class)) {

            Tabela tab = (Tabela) typeClass.getAnnotation(Tabela.class);

            sql = "UPDATE " + tab.nome() + " SET ";

            ArrayList<Field> fieldsUsados = new ArrayList<>();
            Field primaryField = null;
            Coluna primaryColuna = null;

            for (Field field : typeClass.getDeclaredFields()) {

                if (field.isAnnotationPresent(Coluna.class)) {
                    if (field.getAnnotation(Coluna.class).primaryKey()) {
                        primaryField = field;
                        primaryColuna = field.getAnnotation(Coluna.class);
                    }
                }
            }

            try {

                for (Field field : typeClass.getDeclaredFields()) {

                    if (field.isAnnotationPresent(Coluna.class)) {

                        Coluna col = field.getAnnotation(Coluna.class);

                        if (!col.primaryKey()) {

                            fieldsUsados.add(field);

                            sql += col.nome() + " = CASE " + primaryColuna.nome();

                            for (T t : lista) {

                                System.out.println(field.get(t));

                                sql += " WHEN ?  THEN ?\n";

                            }

                            sql += " ELSE NULL \nEND,";
                        }

                    }

                }

                sql = sql.substring(0, sql.length() - 1);

                sql += " WHERE " + primaryColuna.nome() + " IN (";

                for (T t : lista) {

                    sql += "?,";

                }

                sql = sql.substring(0, sql.length() - 1) + ")";

                System.out.println(sql);

                Connection conexao = new ConnectionFactory(nomeBanco).obterConexao(); //botar o banco certo

                PreparedStatement pstmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

                for (int i = 0; i < fieldsUsados.size(); i++) {
                    
                    Field field = fieldsUsados.get(i);

                    Coluna col = field.getAnnotation(Coluna.class);

                    for (int j = 0; j < lista.size(); j++) {

                        T t = lista.get(j);

                        pstmt.setObject(i * lista.size() * 2 + 2 * j + 1, primaryField.get(t), primaryColuna.tipo());

                        if (col.tipo() == Types.BLOB) {
                            
                            pstmt.setBlob(i * lista.size() * 2 + 2 * j + 2, (Blob) field.get(t));
                            
                        } else {

                            pstmt.setObject(i * lista.size() * 2 + 2 * j + 2, field.get(t), col.tipo());
                        }

                    }

                }

                for (int i = 0; i < lista.size(); i++) {
                    
                    T t = lista.get(i);

                    pstmt.setObject(fieldsUsados.size() * lista.size() * 2 + i + 1, primaryField.get(t), primaryColuna.tipo());

                }

                System.out.println(pstmt);

                pstmt.execute();
                pstmt.close();

            } catch (Exception e) {

                System.out.println(e.getMessage());

            }

        } else {
            System.out.println("Esaa classe não tem @Tabela");
        }

    }

    /**
     * Gerador de comando SELECT * [...] 
     * @return lista dos objetos obtidos a partir do SELECT
     */
    public ArrayList<T> selectAll() {

        String sql = "";

        if (typeClass.isAnnotationPresent(Tabela.class)) {

            Tabela tab = typeClass.getAnnotation(Tabela.class);

            sql = "SELECT * FROM " + tab.nome();

            ArrayList<T> list = new ArrayList<T>();

            Connection conexao = new ConnectionFactory(nomeBanco).obterConexao();

            
            try {

                Statement pstmt = conexao.createStatement();

                ResultSet rs = pstmt.executeQuery(sql);

                
                
                while (rs.next()) {

                    T obj = typeClass.newInstance();

                    for (Field field : typeClass.getDeclaredFields()) {

                        if (field.isAnnotationPresent(Coluna.class)) {

                            boolean wasAccessible = field.isAccessible();

                            if (!wasAccessible) {
                                field.setAccessible(true);
                            }

                            field.set(obj, rs.getObject(field.getAnnotation(Coluna.class).nome()));

                            if (!wasAccessible) {
                                field.setAccessible(false);
                            }

                        }

                    }

                    list.add(obj);

                }
                
                pstmt.close();

            } catch (Exception e) {

                System.out.println(e.getMessage());

            }

            return list;

        }

        return null;

    }

    /**
     * Gerador de comando SELECT com limite por ID
     * @param comeco primeiro ID a ser procurado
     * @param fim ultimo ID a ser procurado
     * @return lista dos objetos obtidos a partir do SELECT
     */
    public ArrayList<T> selectLimitado(int comeco, int fim) {

        if (comeco > fim) {
            int holder = comeco;
            comeco = fim;
            fim = holder;
        }

        Field primaryField = null;

        for (Field declaredField : typeClass.getDeclaredFields()) {

            try {
                if (declaredField.getAnnotation(Coluna.class).primaryKey()) {
                    primaryField = declaredField;
                    break;
                }
            } catch (Exception e) {
                continue;
            }

        }

        String sql = "";

        if (typeClass.isAnnotationPresent(Tabela.class)) {

            Tabela tab = typeClass.getAnnotation(Tabela.class);

            sql = "SELECT * FROM " + tab.nome() + " WHERE " + primaryField.getAnnotation(Coluna.class).nome() + " BETWEEN " + comeco + " AND " + fim;

            ArrayList<T> list = new ArrayList<T>();

            Connection conexao = new ConnectionFactory(nomeBanco).obterConexao();

            try {

                Statement pstmt = conexao.createStatement();

                ResultSet rs = pstmt.executeQuery(sql);

                while (rs.next()) {

                    T obj = typeClass.newInstance();

                    for (Field field : typeClass.getDeclaredFields()) {

                        if (field.isAnnotationPresent(Coluna.class)) {

                            boolean wasAccessible = field.isAccessible();

                            if (!wasAccessible) {
                                field.setAccessible(true);
                            }

                            field.set(obj, rs.getObject(field.getAnnotation(Coluna.class).nome()));

                            if (!wasAccessible) {
                                field.setAccessible(false);
                            }

                        }

                    }

                    list.add(obj);

                }

                pstmt.close();
                
            } catch (Exception e) {

                System.out.println(e.getMessage());

            }

            return list;

        }

        return null;

    }

}

enum Order{
    
    
    
}
