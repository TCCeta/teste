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
@Tabela(nome = "funcionarios")
public class FuncionariosBean {
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public ClientesBean getCliente() {
		return cliente;
	}

	public void setCliente(ClientesBean cliente) {
		this.cliente = cliente;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Coluna(nome = "cod_idFuncionario", tipo = Types.INTEGER)
    private int id;
    
    @Coluna(nome = "cod_idCliente", tipo = Types.INTEGER)
    private int idCliente;
    private ClientesBean cliente;
    
    @Coluna(nome = "dad_loginFuncionario", tipo = Types.VARCHAR)
    private String login;
    
    @Coluna(nome = "dad_senhaFuncionario", tipo = Types.VARCHAR)
    private String senha;
    
    @Coluna(nome = "dad_cpfFuncionario", tipo = Types.VARCHAR)
    private String cpf;
    
    @Coluna(nome = "dad_nomeFuncionario", tipo = Types.VARCHAR)
    private String nome;
    
    
    
}
