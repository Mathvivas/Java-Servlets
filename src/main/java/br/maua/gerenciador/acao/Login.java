package br.maua.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.maua.gerenciador.modelo.Banco;
import br.maua.gerenciador.modelo.Usuario;

public class Login implements Acao {

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		//System.out.println("Logando " + login);
		
		Banco banco = new Banco();
		Usuario usuario = banco.existeUsuario(login, senha);
		
		if ( usuario != null ) {
			//System.out.println("Usuário existe");
			/* 
			 * Cada requisição é tratada isoladamente, fazendo com que na próxima, 
			 * já não tenhamos os dados do usuário.
			 * 
			 *	Cookies: Arquivo de texto que o servidor pode criar e associar na 
			 *	resposta. Nas próximas requisições, o navegador poderá enviar esse 
			 *	arquivo de texto automaticamente. É como uma chave de entrada.
			 *	Identificação do navegador (e do usuário) -> session ID. 
			 *	A partir dela, o Tomcat sabe que está se comunicando sempre 
			 *	com o mesmo navegador e com o mesmo usuário.
			 *	
			 *	Guarda informações do usuário
			*/
			HttpSession sessao = request.getSession();	// Pega o cookie
			sessao.setAttribute("usuarioLogado", usuario);
			return "redirect:entrada?acao=ListarEmpresas";
		
		} else {
			return "redirect:entrada?acao=LoginForm";
		}
	}
}
