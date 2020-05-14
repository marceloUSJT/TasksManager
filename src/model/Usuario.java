package model;

public class Usuario implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String email;
	private String nome;
	private String senha;
	
	public Usuario() {
		
	}
	
	public Usuario(String email, String nome, String senha) {
		this.email = email;
		this.nome = nome;
		this.senha = senha;
	}
	
	//GET's
	public String getEmail() {
		return this.email;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getSenha() {
		return this.senha;
	}
	
	//SET's
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}

}
