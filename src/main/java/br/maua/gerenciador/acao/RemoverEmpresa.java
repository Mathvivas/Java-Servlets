package br.maua.gerenciador.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.maua.gerenciador.modelo.Banco;
import br.maua.gerenciador.modelo.Empresa;

public class RemoverEmpresa {
	
	public String executar(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		
		System.out.println("removendo empresa");
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		Banco banco = new Banco();
		banco.removerEmpresa(id);
		
		return "redirect:entrada?acao=ListarEmpresas";
	}
}
