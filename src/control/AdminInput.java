package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ProdottiDAO;
import model.VideogiocoDAO;
import model.beans.copiaBean;
import model.beans.videogiocoBean;

public class AdminInput extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AdminInput() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String type = request.getParameter("type");
	if (type.equals("copia")) {
		System.out.println(request.getParameter("prezzo"));
		copiaBean copia = new copiaBean();
		copia.setPercIva(Float.parseFloat(request.getParameter("iva")));
		copia.setNomeConsole(request.getParameter("console"));
		copia.setPrezzo(Float.parseFloat(request.getParameter("prezzo")));
		copia.setTitoloVideogioco(request.getParameter("titolo"));
		copia.setStato(false);
		ProdottiDAO pdao = new ProdottiDAO();
		int quantità = Integer.parseInt(request.getParameter("quantita"));
		for (int i = 0; i < quantità; i++) {
			try {pdao.inscopia(copia);}
			catch (SQLException e) {e.printStackTrace();}
				}
		}
	else if (type.equals("videogioco")) {
		videogiocoBean videogioco = new videogiocoBean();
		videogioco.setDescrizione(request.getParameter("descrizione"));
		videogioco.setPegi(Integer.parseInt(request.getParameter("pegi")));
		videogioco.setTitolo(request.getParameter("titolo"));
		VideogiocoDAO vdao = new VideogiocoDAO();
		try {vdao.inserisciVideogioco(videogioco);}
		catch(Exception e) {e.getMessage();}
		}
	else if(type.equals("changeIVA")) {
		ProdottiDAO pdao = new ProdottiDAO();
		float iva = Float.parseFloat(request.getParameter("percIva"));
		System.out.println(iva);
		try{pdao.cambiaIVA(iva);}
		catch (SQLException e) {e.printStackTrace();}
		}
		RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/admin/admin.jsp");
		rd.forward(request, response);
	}
}
