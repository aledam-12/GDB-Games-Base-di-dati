package control;
import model.OrdineCopia;

import model.AcquistoDAO;
import model.Carrello;
import model.ProdottiDAO;
import model.beans.AcquistoBean;
import model.beans.ClienteBean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/utenteLoggato/Checkout")
public class Checkout extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Carrello carrelloCheckout = (Carrello) req.getSession().getAttribute("carrello");
        ClienteBean cliente = (ClienteBean) req.getSession().getAttribute("cliente");	//il cliente di sicuro sarà registrato
        float prezzoTot = (float) carrelloCheckout.getPrezzoTotale();						//lo garantisce il filtro
        AcquistoBean acquistoBean = new AcquistoBean();
        acquistoBean.setemailcliente(cliente.getEmail());
        acquistoBean.setPrezzoTotale(prezzoTot);
        acquistoBean.setCitta(req.getParameter("citta-spedizione"));
        acquistoBean.setdataAcquisto(LocalDate.now());
        acquistoBean.setnCarta(Integer.parseInt(req.getParameter("numCarta")));
        acquistoBean.setCap(Integer.parseInt(req.getParameter("cap-spedizione")));
        acquistoBean.setVia(req.getParameter("via-spedizione"));
        AcquistoDAO ordineDAO = new AcquistoDAO();
        ProdottiDAO pdao = new ProdottiDAO();
        try {
        	ordineDAO.inserisciOrdine(acquistoBean);
        	req.getSession().removeAttribute("carrello");
        	RequestDispatcher rd = req.getServletContext().getRequestDispatcher("/utenteLoggato/account.jsp");
            rd.forward(req, resp);
            for (OrdineCopia o : carrelloCheckout.viewCart()) {
            	int temp = o.getQuantità();
            	for (int i = 0; i < temp; i++) {
            		pdao.UpdateCopia(o, acquistoBean);
            }
          }
        }
        catch (Exception e) {e.printStackTrace();}
    }
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}
}