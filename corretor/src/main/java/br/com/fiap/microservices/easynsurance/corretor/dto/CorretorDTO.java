package br.com.fiap.microservices.easynsurance.corretor.dto;

import br.com.fiap.microservices.easynsurance.corretor.entity.Corretor;

public class CorretorDTO {

	private Long id;
	private String nome;
	private String endereco;
	private String emailUsuario;
	private String password;
	private int idade;
	private String cpf;
	private String telefone;
	
	
	
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public CorretorDTO() {

	}
	
	public CorretorDTO(Corretor corretor) {
		this.id = corretor.getId();
		this.nome = corretor.getNome();
		this.endereco = corretor.getEndereco();
		this.emailUsuario = corretor.getEmail();
		this.password = corretor.getPassword();
		this.idade = corretor.getIdade();
		this.telefone = corretor.getTelefone();
		this.cpf = corretor.getCpf();
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
	public String getEmailUsuario() {
		return emailUsuario;
	}
	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
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
