package br.com.fiap.microservices.easynsurance.corretor.dto;

import br.com.fiap.microservices.easynsurance.corretor.entity.Cliente;

public class CorretorDTO {

	private Long id;
	private String nome;
	private String endereco;
	private String nomeUsuario;
	private String password;
	private int idade;
	private String cpf;
	
	public CorretorDTO() {

	}
	
	public CorretorDTO(Cliente corretor) {
		this.id = corretor.getId();
		this.nome = corretor.getNome();
		this.endereco = corretor.getEndereco();
		this.nomeUsuario = corretor.getNomeUsuario();
		this.password = corretor.getPassword();
		this.idade = corretor.getIdade();
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
