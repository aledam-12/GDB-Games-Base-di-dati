package model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.beans.AcquistoBean;
import model.beans.VideogiocoBean;

@WebServlet("/Admin")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Admin() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		AcquistoDAO adao = new AcquistoDAO();
		if (action.contentEquals("orders")) {
			String sort = request.getParameter("sort");
			try {ArrayList <AcquistoBean> acquisti = (ArrayList <AcquistoBean>) adao.leggiTuttiOrdini(sort);
			request.setAttribute("acquisti", acquisti);
			}
			catch (SQLException e) {e.getStackTrace();}
		}
		if (action.equals("insertgame")) {
			VideogiocoBean videogioco = new VideogiocoBean();
			//distinzioneDAO ddao = new distinzioneDAO();
			String titolo = request.getParameter("titolo-videogioco");
			//String genere = request.getParameter("genere-videogioco");
			int pegi = Integer.parseInt(request.getParameter("pegi"));
			String descrizione = request.getParameter("descrizione-videogioco");
			videogioco.setDescrizione(descrizione);
			videogioco.setTitolo(titolo);
			videogioco.setPegi(pegi);
			/* ddao.insertVideogioco (videogioco, genere) */
			
		}
	}
}
