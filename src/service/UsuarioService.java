package service;

import model.Usuario;

import java.sql.SQLException;

import dao.UsuarioDAO;

public class UsuarioService {
	private UsuarioDAO usuarioDAO;	
	public UsuarioService() {
		this.usuarioDAO = new UsuarioDAO();
	}
	
	public void cadastrarUsuario(Usuario usuario) {
		usuarioDAO.cadastrar(usuario);
	}
	
	public void excluirUsuario(Usuario usuario) {
		usuarioDAO.excluir(usuario);
	}
	
	public Usuario login(Usuario usuario) {
		try {
			Usuario user = usuarioDAO.login(usuario);
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
