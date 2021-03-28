package br.maua.gerenciador.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.maua.gerenciador.acao.Acao;
import br.maua.gerenciador.acao.AlterarEmpresa;
import br.maua.gerenciador.acao.ListarEmpresas;
import br.maua.gerenciador.acao.MostrarEmpresa;
import br.maua.gerenciador.acao.NovaEmpresa;
import br.maua.gerenciador.acao.NovaEmpresaForm;
import br.maua.gerenciador.acao.RemoverEmpresa;

// Controller
//localhost:8080/gerenciador/entrada?acao=...

@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String paramAcao = request.getParameter("acao");
		String nomeDaClasse = "br.maua.gerenciador.acao." + paramAcao;
		
		String nome;
		try {
			Class classe = Class.forName(nomeDaClasse);	// Carrega a classe com o nome
			Acao acao = (Acao) classe.newInstance();
			nome = acao.executar(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException 
				| IOException | ServletException e) {
			throw new ServletException(e);
		}
		
		String[] tipoEEndereco =  nome.split(":");
		if ( tipoEEndereco[0].equals("forward") ) {
			RequestDispatcher rd = request.getRequestDispatcher(
					"WEB-INF/view/" + tipoEEndereco[1]
			);
			rd.forward(request, response);	
		} else {
			response.sendRedirect(tipoEEndereco[1]);
		}
	}

}
