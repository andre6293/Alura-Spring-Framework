package br.com.alura.gerenciador.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class ExcluirEmpresa implements Action{
	
	public String executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Empresa> empresas = Banco.getEmpresas();
		Integer id = Integer.valueOf(request.getParameter("id"));
		
		Banco banco = new Banco();
		banco.removerEmpresa(id);
		
		for (Empresa empresa : empresas) {
			if(empresa.getId() == id)
				empresas.remove(id);
		}
		
		return "redirect:entrada?action=ListarEmpresas";		
	}
}