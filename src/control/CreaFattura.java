package control;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ClienteDAO;
import model.Fattura;
import model.beans.ClienteBean;

public class CreaFattura extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CreaFattura() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		ClienteBean cliente = (ClienteBean) request.getSession(false).getAttribute("cliente");
		ClienteDAO cdao = new ClienteDAO();
		if (!cliente.getStato().equals("admin")) {
			Fattura fattura = new Fattura();
			try {
			if (!cdao.controlloFattura(cliente, id)) response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			fattura.creaFattura(id, cliente);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		else {
			Fattura fattura = new Fattura();
			try {
				fattura.creaFattura(id, cliente);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("ridireziono a fattura "+id);
		RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/pdf/fattura "+id+".pdf");
		rd.forward(request, response);
	}
}
