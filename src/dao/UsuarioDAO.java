package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Usuario;

public class UsuarioDAO {
	
	private Connection conexao;
	
	public UsuarioDAO() {
		this.conexao = ConnectionFactory.conectar();
	}

	public void cadastrar(Usuario usuario) {
			
		String inserir = "INSERT INTO usuario "
				+ " (email, senha, nome) "
				+ " VALUES (?, ?, ?) ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(inserir) ) {
			
			pst.setString(1, usuario.getEmail());
			pst.setString(2, usuario.getSenha());
			pst.setString(3, usuario.getNome());
			
			pst.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela usuario.");
			ex.printStackTrace();
			
		}
	}
	
	public void excluir(Usuario usuario) {
		
		String excluir = "DELETE FROM comentario "
				+ " WHERE fk_noticia_id = ? ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(excluir) ) {
			
			pst.setString(1, usuario.getEmail());
			
			pst.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela Usuario.");
			ex.printStackTrace();
		}
	}
	
	public Usuario login(Usuario user) throws SQLException {

      
        Usuario usuario = new Usuario();
        
        String select = "SELECT * FROM usuario WHERE email = '"+user.getEmail()+"'";

        PreparedStatement smt = conexao.prepareStatement(select);

        ResultSet resultSet = smt.executeQuery();

        while (resultSet.next()) {
            if (resultSet.getString("senha").equals(user.getSenha())) {
                usuario.setNome(resultSet.getString("nome"));
                usuario.setEmail(resultSet.getString("email"));
                usuario.setSenha(resultSet.getString("senha"));
                
                return usuario;
            }
        }
        if(resultSet.getFetchSize() == 0) {
        	usuario.setNome("erro");;
        	return usuario;
        }

        conexao.close();
        smt.close();

        return null;
    }
}