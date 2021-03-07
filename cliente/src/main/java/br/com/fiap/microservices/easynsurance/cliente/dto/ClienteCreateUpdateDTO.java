package br.com.fiap.microservices.easynsurance.cliente.dto;

public class ClienteCreateUpdateDTO {

	private String nome;
	private String endereco;
	private String telefone;
	private String emailUsuario;
	private String password;
	private int idade;
	private String cpf;
	
	
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
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
	public boolean validaDadosMinimosEnviados() {
		return (this.cpf == null || this.cpf == "") || 
				(this.emailUsuario == null || this.emailUsuario == "") || 
				(this.endereco == null || this.endereco == "") || 
				(this.idade == 0 || this.idade > 110 || this.idade < 18) || 
				(this.nome == null || this.nome == "") || 
				(this.password == null || this.password == "") || 
				(this.telefone == null || this.telefone == ""); 
	}

}
