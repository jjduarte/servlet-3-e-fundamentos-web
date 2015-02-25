package br.com.alura.gerenciador.web;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.alura.gerenciador.Usuario;
import br.com.alura.gerenciador.dao.UsuarioDAO;

public class Login implements Tarefa {
	final static Map<String, Usuario> USUARIOS_LOGADOS = new HashMap<>();

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		String msg = "";
		Usuario usuario = new UsuarioDAO().buscaPorEmailESenha(email, senha);
		if (usuario == null) {
			msg = "Usuário inválido.";
		} else {
			req.getSession().setAttribute("usuarioLogado", usuario);
			msg = "Usuario logado: " + usuario.getEmail();
		}
		req.setAttribute("msg", msg);
		return "/WEB-INF/paginas/login.html";
	}
}
