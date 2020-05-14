package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usuario;
import service.UsuarioService;

@WebServlet("/Login.do")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Login() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter saida = response.getWriter();
		
		saida.println("Você precisa passar pelo formulário primeiro!");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		Usuario usuario = new Usuario();
		usuario.setEmail(email);
		usuario.setSenha(senha);

		HttpSession sessao = request.getSession();
		UsuarioService service = new UsuarioService();
		Usuario logado = service.login(usuario);
		String pagina;
		
		if(logado.getNome().contentEquals("erro")) {
			sessao.setAttribute("mensagem", "Usuário ou senha incorretos!");
			pagina = "./jsp/login.jsp";
		}else {
			sessao.setAttribute("nome", logado.getNome());
			sessao.setAttribute("email", logado.getEmail());
			pagina = "./jsp/tasks.jsp";
		}
		
		response.sendRedirect(pagina);
	
	}

}
