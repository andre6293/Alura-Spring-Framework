package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MostraEmpresaServlet", urlPatterns = { "/mostraEmpresa" })
public class MostraEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Empresa> empresas = Banco.getEmpresas();
		Integer id = Integer.valueOf(request.getParameter("id"));
		
		Banco banco = new Banco();
		
		Empresa empresa = banco.buscaPorId(id);
		
		RequestDispatcher rd = request.getRequestDispatcher("/formModificaEmpresa.jsp");
		
		request.setAttribute("nome", empresa.getNome());
		request.setAttribute("data", empresa.getDataAbertura());
		request.setAttribute("id", empresa.getId());
		
		rd.forward(request, response);
	}

}
