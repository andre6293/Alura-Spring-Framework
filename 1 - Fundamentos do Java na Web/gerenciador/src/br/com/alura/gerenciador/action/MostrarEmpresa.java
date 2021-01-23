package br.com.alura.gerenciador.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class MostrarEmpresa implements Action {

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<Empresa> empresas = Banco.getEmpresas();
		Integer id = Integer.valueOf(request.getParameter("id"));
		
		Banco banco = new Banco();
		
		Empresa empresa = banco.buscaPorId(id);
		
		RequestDispatcher rd = request.getRequestDispatcher("/formModificaEmpresa.jsp");
		
		request.setAttribute("nome", empresa.getNome());
		request.setAttribute("data", empresa.getDataAbertura());
		request.setAttribute("id", empresa.getId());
		
		return "forward:formModificaEmpresa.jsp";
	}
}
