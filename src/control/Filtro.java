package control;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Filtro implements Filter{

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		HttpSession session = request.getSession();
		String role = (String) session.getAttribute("auth");
		String amministratoreURI = request.getContextPath()+"/admin";
		String userLoggedURI = request.getContextPath()+"/utenteLoggato";		
		if (request.getRequestURI().startsWith(amministratoreURI)) {
			boolean isLogged = session != null && session.getAttribute("auth") != null;
			if (!isLogged) {response.sendRedirect(request.getContextPath()+ "/Login.jsp"); return;}
			else if (!role.equals("admin")) {
			response.sendError(HttpServletResponse.SC_FORBIDDEN); 	return;}
			else chain.doFilter(req,resp);		//filtro per le risorse amministratore
		}
		else if (request.getRequestURI().startsWith(userLoggedURI)) {
			boolean isLogged = session != null && session.getAttribute("auth") != null;
			if (!isLogged) {response.sendRedirect(request.getContextPath()+ "/Login.jsp"); return;}
			else chain.doFilter(req,resp);		//filtro per le risorse utente loggato
		}
		else chain.doFilter(request, response); //filtro per le risorse accessibili a tutti
	}
}
