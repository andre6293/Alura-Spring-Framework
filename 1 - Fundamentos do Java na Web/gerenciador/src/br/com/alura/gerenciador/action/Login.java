package br.com.alura.gerenciador.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Usuario;

public class Login implements Action {

	public String executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String loginDigitado = request.getParameter("login");
		String senhaDigitada = request.getParameter("password");
		
		
		Banco banco = new Banco();
		Usuario usuario = banco.usuarioExiste(loginDigitado, senhaDigitada);
		
		if (usuario != null) {
			System.out.println(loginDigitado + ", " + senhaDigitada);

			HttpSession sessao = request.getSession();
			sessao.setAttribute("usuarioLogado", usuario);
			
			return "redirect:entrada?action=ListarEmpresas";
		} else {
			return "redirect:entrada?action=LoginForm";
		}
	}
}