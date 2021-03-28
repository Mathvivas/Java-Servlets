package br.maua.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NovaEmpresaForm implements Acao {
	
	public String executar(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		
		return "forward:formNovaEmpresa.jsp";
	}
}
