package br.maua.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.maua.gerenciador.modelo.Banco;
import br.maua.gerenciador.modelo.Empresa;

public class NovaEmpresaForm {
	
	public String executar(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		
		return "forward:formNovaEmpresa.jsp";
	}
}
