package br.maua.gerenciador.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.maua.gerenciador.modelo.Banco;
import br.maua.gerenciador.modelo.Empresa;

public class MostrarEmpresa implements Acao {
	
	public String executar(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		
		System.out.println("mostrando dados da empresa");
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		Banco banco = new Banco();
		Empresa empresa = banco.buscarEmpresaPeloId(id);
		
		request.setAttribute("empresa", empresa);
		
		return "forward:formAlteraEmpresa.jsp";
	}
}
