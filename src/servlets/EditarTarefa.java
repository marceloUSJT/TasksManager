package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.TarefasService;
import model.Tarefas;

@WebServlet("/editarTarefa.do")
public class EditarTarefa extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EditarTarefa() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String titulo = request.getParameter("titulo");
		String descricao = request.getParameter("descricao");
		Tarefas tarefa = new Tarefas();
		tarefa.setTitulo(titulo);
		tarefa.setDescricao(descricao);
		tarefa.setId(id);
		
		TarefasService service = new TarefasService();
		service.alterarTarefa(tarefa);		
		
		response.sendRedirect("./jsp/tasks.jsp");
	}

}
