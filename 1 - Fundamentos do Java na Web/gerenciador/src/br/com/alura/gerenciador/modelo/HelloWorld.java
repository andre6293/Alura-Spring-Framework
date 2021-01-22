package br.com.alura.gerenciador.modelo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/helloworld")
public class HelloWorld extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	int contagem = 0;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("Hello World!");
		out.println("</body>");
		out.println("</html>");
		contagem++;
		
		System.out.println("O servlet Hello world foi chamado " + contagem + " vezes");
	}
}
