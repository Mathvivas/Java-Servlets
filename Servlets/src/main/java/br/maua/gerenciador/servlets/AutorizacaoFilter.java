package br.maua.gerenciador.servlets;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AutorizacaoFilter
 */
@WebFilter("/entrada")
public class AutorizacaoFilter implements Filter {

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, 
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		String paramAcao = request.getParameter("acao");

		HttpSession sessao = request.getSession();
		boolean usuarioNaoLogado = (sessao.getAttribute("usuarioLogado") ==  null);
		// Páginas protegidas redirecionarão
		boolean ehUmaAcaoProtegida = !(paramAcao.equals("Login") || 
				paramAcao.equals("LoginForm"));
		
		if ( ehUmaAcaoProtegida && usuarioNaoLogado ) {
			response.sendRedirect("entrada?acao=LoginForm");
			return;
		}
		
		chain.doFilter(request, response);
	}
}
