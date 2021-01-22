package br.com.alura.gerenciador.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.servlet.modelo.Banco;
import br.com.alura.gerenciador.servlet.modelo.Empresa;

public class ListarEmpresas implements Action {
	
	public void executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		List<Empresa> empresas = Banco.getEmpresas();
		
		RequestDispatcher rd = request.getRequestDispatcher("/empresas.jsp");
		request.setAttribute("empresas", empresas);
		rd.forward(request, response);
	}
}
