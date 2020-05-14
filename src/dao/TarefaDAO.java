package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Tarefas;

import java.sql.ResultSet;

public class TarefaDAO {
	
	private Connection conexao;
	
	public TarefaDAO() {
		this.conexao = ConnectionFactory.conectar();
	}

	public void cadastrar(Tarefas tarefa) {
			
		String inserir = "INSERT INTO tarefas "
				+ " (titulo, descricao, fk_usuario_email) "
				+ " VALUES (?, ?, ?) ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(inserir) ) {
			
			pst.setString(1, tarefa.getTitulo());
			pst.setString(2, tarefa.getDescricao());
			pst.setString(3, tarefa.getUsuarioEmail());
			
			pst.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela Tarefas.");
			ex.printStackTrace();
			
		}
	}
	
	public void alterar(Tarefas tarefa) {
		
		String alterar = "UPDATE tarefas "
				+ "SET titulo = ?, descricao = ? WHERE id = ? ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(alterar) ) {
			
			pst.setString(1, tarefa.getTitulo());
			pst.setString(2, tarefa.getDescricao());
			pst.setInt(3, tarefa.getId());
			
			pst.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela Tarefas.");
			ex.printStackTrace();
			
		}
	}
	
	public void excluir(Tarefas tarefa) {
		
		String excluir = "DELETE FROM tarefas "
				+ " WHERE id = ? ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(excluir) ) {
			
			pst.setInt(1, tarefa.getId());
			
			pst.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela Tarefas.");
			ex.printStackTrace();
		}
	}
	
	public ArrayList<Tarefas> listarTarefas(String emailUsuario) {
		
		String consultar = "SELECT * FROM tarefas WHERE fk_usuario_email = ?";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(consultar) ) {
			
			pst.setString(1, emailUsuario);
			
			ResultSet resultado = pst.executeQuery();
			
			ArrayList<Tarefas> lista = new ArrayList<>();
			while (resultado.next()) {
				Tarefas t = new Tarefas();
				t.setId(resultado.getInt("id"));
				t.setDescricao(resultado.getString("descricao"));
				t.setTitulo(resultado.getString("titulo"));
				lista.add(t);
			}
			return lista;
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela Tarefas.");
			ex.printStackTrace();
			
			return null;
		}
	}
	
	public Tarefas consultar(int id) {
		
		String consultar = "SELECT * FROM tarefas "
				+ " WHERE id = ? ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(consultar) ) {
			
			pst.setInt(1, id);
			ResultSet resultado = pst.executeQuery();
			
			Tarefas t = new Tarefas();
			if (resultado.next()) {
				t.setId(id);
				t.setDescricao(resultado.getString("descricao"));
				t.setTitulo(resultado.getString("titulo"));			}
			return t;
					
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela Tarefas.");
			ex.printStackTrace();
			
			return null;
		}
	}

}