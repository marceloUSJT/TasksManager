package service;

import model.Tarefas;
import dao.TarefaDAO;
import java.util.ArrayList;

public class TarefasService {
	private TarefaDAO tarefasDAO;
	
	public TarefasService() {
		this.tarefasDAO = new TarefaDAO();
	}
	
	public ArrayList<Tarefas> listarNoticias(String emailUsuario) {
		ArrayList<Tarefas> lista = tarefasDAO.listarTarefas(emailUsuario);
		
		return lista;
	}
	
	public void cadastrarTarefa(Tarefas tarefa) {
		tarefasDAO.cadastrar(tarefa);
	}
	
	public void alterarTarefa(Tarefas tarefa) {
		tarefasDAO.alterar(tarefa);
	}
	
	public void excluirTarefa(int id) {
		Tarefas tarefa = new Tarefas();
		tarefa.setId(id);		
		tarefasDAO.excluir(tarefa);
	}
	
	public Tarefas consultar(int id) {
		Tarefas tarefa = tarefasDAO.consultar(id);
		
		return tarefa;
	}
	
	public ArrayList<Tarefas> listarTarefas(String email){
		ArrayList<Tarefas> lista = tarefasDAO.listarTarefas(email);
		
		return lista;
	}
	
}
