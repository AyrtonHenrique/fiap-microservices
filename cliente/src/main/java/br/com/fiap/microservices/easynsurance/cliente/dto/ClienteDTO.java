package br.com.fiap.microservices.easynsurance.cliente.dto;

import br.com.fiap.microservices.easynsurance.cliente.entity.Cliente;

public class ClienteDTO {

	private Long id;
	private String nome;
	private String endereco;
	private String nomeUsuario;
	private String password;
	private int idade;
	private String cpf;
	
	public ClienteDTO() {

	}
	
	public ClienteDTO(Cliente cliente) {
		this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.endereco = cliente.getEndereco();
		this.nomeUsuario = cliente.getNomeUsuario();
		this.password = cliente.getPassword();
		this.idade = cliente.getIdade();
		this.cpf = cliente.getCpf();
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	
	
}
