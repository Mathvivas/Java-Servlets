package br.maua.gerenciador.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.maua.gerenciador.acao.AlterarEmpresa;
import br.maua.gerenciador.acao.ListarEmpresas;
import br.maua.gerenciador.acao.MostrarEmpresa;
import br.maua.gerenciador.acao.NovaEmpresa;
import br.maua.gerenciador.acao.RemoverEmpresa;

@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramAcao = request.getParameter("acao");
		
		// localhost:8080/gerenciador/entrada?acao=...
		
		if ( paramAcao.equals("ListarEmpresas") ) {
			
			ListarEmpresas acao = new ListarEmpresas();
			acao.executar(request, response);
		
		} else if ( paramAcao.equals("RemoverEmpresa") ) {
			
			RemoverEmpresa acao = new RemoverEmpresa();
			acao.executar(request, response);
		
		} else if ( paramAcao.equals("MostrarEmpresa") ) {
			
			MostrarEmpresa acao = new MostrarEmpresa();
			acao.executar(request, response);
		
		} else if ( paramAcao.equals("AlterarEmpresa") ) {
			
			AlterarEmpresa acao = new AlterarEmpresa();
			acao.executar(request, response);
			
		} else if ( paramAcao.equals("NovaEmpresa") ) {
			
			NovaEmpresa acao = new NovaEmpresa();
			acao.executar(request, response);
		}
	}

}
