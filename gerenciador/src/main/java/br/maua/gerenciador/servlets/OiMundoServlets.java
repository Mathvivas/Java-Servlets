package br.maua.gerenciador.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Ctrl Espace para opções

@WebServlet( urlPatterns = "/oi")		// Fornece um apelido no endereço URL qu remete ao Servlet do gerenciador
public class OiMundoServlets extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		// Devolve um conteúdo HTML
		PrintWriter out = resp.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		out.println("Oi, Mundo! Parabéns! Você escreveu o  primeiro Servlets!");
		out.println("</body>");
		out.println("</html>");
	}
}
