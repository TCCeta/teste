/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jsp.bean;

import br.com.jsp.bean.Annotations.Coluna;
import br.com.jsp.bean.Annotations.Tabela;
import java.sql.Types;

/**
 *
 * @author 103782
 */
@Tabela(nome = "usuarios")
public class UsuariosBean {
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Coluna(autoGerado = true,nome = "cod_idUsuario",primaryKey = true,tipo = Types.INTEGER)
    private int id;
    
    @Coluna(nome = "dad_nomeUsuario", tipo = Types.VARCHAR)
    private String nome;
    
    @Coluna(nome = "dad_loginUsuario", tipo = Types.VARCHAR)
    private String login;
    
    @Coluna(nome = "dad_senhaUsuario", tipo = Types.VARCHAR)
    private String senha;
    
    @Coluna(nome = "dad_cpfUsuario", tipo = Types.VARCHAR)
    private String cpf;
    
}
