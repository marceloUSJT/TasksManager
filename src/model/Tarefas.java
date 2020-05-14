package model;

public class Tarefas implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String titulo;
	private String descricao;
	private String usuario_email;
	
	public Tarefas() {
		
	}
	
	public Tarefas(String titulo, String descricao, String usuario_email) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.usuario_email = usuario_email;
	}
	
	//GET's
	public int getId() {
		return this.id;
	}
	
	public String getTitulo() {
		return this.titulo;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public String getUsuarioEmail() {
		return this.usuario_email;
	}
	
	//SET's
	public void setId(int id) {
		this.id = id;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public void setUsuarioEmail(String usuarioEmail) {
		this.usuario_email = usuarioEmail;
	}
}
