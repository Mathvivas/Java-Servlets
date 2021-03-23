package br.maua.gerenciador.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NovaEmpresaServlet
 */
@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet  {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Método GET
		// http://localhost:8080/gerenciador/novaEmpresa?nome=Alura
		
		System.out.println("Cadastrando Nova Empresa");
		
		String nomeEmpresa = request.getParameter("nome");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html><body>Empresa " + nomeEmpresa + " Cadastrada com Sucesso!</body></html>");
	}
}
