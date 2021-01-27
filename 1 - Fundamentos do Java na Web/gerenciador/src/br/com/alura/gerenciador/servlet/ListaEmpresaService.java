package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

@WebServlet("/empresas")
public class ListaEmpresaService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String tipoReq = request.getHeader("Accept");
		
		if(tipoReq.toLowerCase().endsWith("xml")) {
			XStream xstream = new XStream();
			xstream.alias("empresa", Empresa.class);
			String xml = xstream.toXML(Banco.getEmpresas());
			
			response.setContentType("application/xml");
			response.getWriter().print(xml);
			
		} else if(tipoReq.toLowerCase().endsWith("json")) {			
			Gson gson = new Gson();
			String json = gson.toJson(Banco.getEmpresas());
			
			response.setContentType("application/json");
			response.getWriter().print(json);
			
		} else {
			response.setContentType("application/json");
			response.getWriter().print("{'message': 'no content'}");
		}
	}
}