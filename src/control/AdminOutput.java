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
import model.beans.acquistoBean;

public class AdminOutput extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AdminOutput() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList <acquistoBean> ordini = new ArrayList <>();
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
				ordini = (ArrayList <acquistoBean>)adao.leggiTuttiOrdini("");
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
