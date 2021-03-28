package br.maua.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.maua.gerenciador.modelo.Banco;

public class RemoverEmpresa implements Acao {
	
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
