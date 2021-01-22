package br.com.alura.gerenciador.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class ListarEmpresas implements Action {
	
	public String executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		List<Empresa> empresas = Banco.getEmpresas();
		
		RequestDispatcher rd = request.getRequestDispatcher("/empresas.jsp");
		request.setAttribute("empresas", empresas);
		
		return "forward:empresas.jsp";
	}
}
