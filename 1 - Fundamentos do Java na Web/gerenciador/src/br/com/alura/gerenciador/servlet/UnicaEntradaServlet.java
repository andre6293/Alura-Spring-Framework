package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.action.Action;
import br.com.alura.gerenciador.action.CriarEmpresa;
import br.com.alura.gerenciador.action.ExcluirEmpresa;
import br.com.alura.gerenciador.action.ListarEmpresas;
import br.com.alura.gerenciador.action.ModificarEmpresa;
import br.com.alura.gerenciador.action.MostrarEmpresa;

@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramAction = request.getParameter("action");
		Action acao = null;
		
		if (paramAction.equals("listarEmpresas")) {
			System.out.println("Listando empresas");
			acao = new ListarEmpresas();
			
		} else if (paramAction.equals("modificarEmpresa")) {
			System.out.println("Modificando empresa");
			acao = new ModificarEmpresa();
			
		} else if (paramAction.equals("mostrarEmpresa")) {
			System.out.println("Mostrando empresa");
			acao = new MostrarEmpresa();
			
		} else if (paramAction.equals("excluirEmpresa")) {
			System.out.println("Excluindo empresa");
			acao = new ExcluirEmpresa();
		
		} else if (paramAction.equals("criarEmpresa")) {
			System.out.println("Criando empresa");
			acao = new CriarEmpresa();
		}
		
		acao.executar(request, response);
	}
}