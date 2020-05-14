package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.TarefasService;
import model.Tarefas;

@WebServlet("/criarTarefa.do")
public class CriarTarefa extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CriarTarefa() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String titulo = request.getParameter("titulo");
		String descricao = request.getParameter("descricao");
		String emailUsuario = request.getParameter("emailUsuario");
		Tarefas tarefa = new Tarefas();
		tarefa.setTitulo(titulo);
		tarefa.setDescricao(descricao);
		tarefa.setUsuarioEmail(emailUsuario);
		
		TarefasService service = new TarefasService();
		service.cadastrarTarefa(tarefa);	
		
		response.sendRedirect("./jsp/tasks.jsp");
	}

}
