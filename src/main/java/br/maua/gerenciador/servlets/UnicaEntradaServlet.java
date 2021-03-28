package br.maua.gerenciador.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
		
		String nome = null;
		if ( paramAcao.equals("ListarEmpresas") ) {
			
			ListarEmpresas acao = new ListarEmpresas();
			nome = acao.executar(request, response);
		
		} else if ( paramAcao.equals("RemoverEmpresa") ) {
			
			RemoverEmpresa acao = new RemoverEmpresa();
			nome = acao.executar(request, response);
		
		} else if ( paramAcao.equals("MostrarEmpresa") ) {
			
			MostrarEmpresa acao = new MostrarEmpresa();
			nome = acao.executar(request, response);
		
		} else if ( paramAcao.equals("AlterarEmpresa") ) {
			
			AlterarEmpresa acao = new AlterarEmpresa();
			nome = acao.executar(request, response);
			
		} else if ( paramAcao.equals("NovaEmpresa") ) {
			
			NovaEmpresa acao = new NovaEmpresa();
			nome = acao.executar(request, response);
		}
		
		String[] tipoEEndereco =  nome.split(":");
		if ( tipoEEndereco[0].equals("forward") ) {
			RequestDispatcher rd = request.getRequestDispatcher(tipoEEndereco[1]);
			rd.forward(request, response);	
		} else {
			response.sendRedirect(tipoEEndereco[1]);
		}
	}

}
