package br.maua.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginForm implements Acao {

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		return "forward:formLogin.jsp";
	}

}
