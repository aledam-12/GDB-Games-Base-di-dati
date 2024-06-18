package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProdottiDAO;
import model.VideogiocoDAO;
import model.beans.CopiaBean;


public class AdminUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AdminUpdate() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		if (type.equals("copia")) {
			CopiaBean copia = new CopiaBean();
			copia.setNomeConsole(request.getParameter("OldConsole"));
			copia.setPrezzo(Float.parseFloat(request.getParameter("OldPrezzo")));
			copia.setTitoloVideogioco(request.getParameter("titolo"));
			ProdottiDAO pdao = new ProdottiDAO();
			try {
				pdao.modificaCopia(copia, request.getParameter("console"), Float.parseFloat(request.getParameter("prezzo")));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (type.equals("videogioco")) {
			VideogiocoDAO vdao = new VideogiocoDAO();
			try {String descrizione = request.getParameter("descrizione");
			String titolo = request.getParameter("titolo");
			int pegi = Integer.parseInt(request.getParameter("pegi"));
			if (descrizione == null || descrizione.isBlank()) {
				vdao.modificaprod(titolo, pegi);
			}
			else vdao.modificaprod(titolo, descrizione, pegi);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/admin/admin.jsp");
		rd.forward(request, response);
	}

}
