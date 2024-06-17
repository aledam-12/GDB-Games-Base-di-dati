package control;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AcquistoDAO;
import model.OrdineCopia;
import model.ProdottiDAO;
import model.VideogiocoDAO;
import model.beans.AcquistoBean;
import model.beans.VideogiocoBean;

public class AdminOutput extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AdminOutput() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList <AcquistoBean> ordini = new ArrayList <>();
		ArrayList <OrdineCopia> prodotti = new ArrayList <> ();
		ArrayList <VideogiocoBean> videogiochi = new ArrayList <>();
		ProdottiDAO pdao = new ProdottiDAO();
		VideogiocoDAO vdao = new VideogiocoDAO();
		try {
			videogiochi = vdao.leggiTutti();
			prodotti = pdao.getProdotti();
			request.setAttribute("prodotti", prodotti);
			request.setAttribute("videogiochi", videogiochi);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
			AcquistoDAO adao = new AcquistoDAO();
			try {
			String inizio = request.getParameter("inizio");
			String fine = request.getParameter("fine");
			String emailCliente = request.getParameter("email-cliente");
			if (inizio != null && fine != null) {
				LocalDate dataInizio = LocalDate.parse(inizio);
				LocalDate dataFine = LocalDate.parse(fine);
				ordini = adao.cercaOrdini(dataInizio, dataFine, emailCliente);
				request.setAttribute("ordini", ordini);
			}
			else {
				ordini = (ArrayList <AcquistoBean>)adao.leggiTuttiOrdini("");
				request.setAttribute("ordini", ordini);	
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			RequestDispatcher disp = request.getServletContext().getRequestDispatcher("/admin/admin.jsp");
			disp.forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
