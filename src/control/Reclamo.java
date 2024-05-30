package control;

import model.ReclamoDAO;
import model.beans.reclamoBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/reclamo")
public class Reclamo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
		String utenteId = request.getParameter("chiaveCliente");
		String titolo = request.getParameter("titolo");
		String descrizione = request.getParameter("descrizione");
		ReclamoDAO ReclamoDAO = new ReclamoDAO();
		reclamoBean reclamo = new reclamoBean();
		reclamo.setEmailCliente(utenteId);
		reclamo.settitolo(titolo);
		reclamo.setcontenuto(descrizione);
		try {
			ReclamoDAO.inseriscireclamo(reclamo);
		} catch (SQLException e) {
			e.printStackTrace();
		}


		boolean reclamoToken = true;
		request.setAttribute("reclamoFlag", reclamoToken);
	    response.sendRedirect("account.jsp");
	
	}
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost(request,response);
    }
}