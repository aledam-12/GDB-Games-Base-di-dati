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
        ClienteBean cliente = (ClienteBean) req.getSession().getAttribute("cliente");	//il cliente di sicuro sar� registrato
        float prezzoTot = (float) carrelloCheckout.getPrezzoTotale();						//lo garantisce il filtro
        AcquistoBean acquistoBean = new AcquistoBean();
        acquistoBean.setemailcliente(cliente.getEmail());
        acquistoBean.setPrezzoTotale(prezzoTot);
        acquistoBean.setCitta(req.getParameter("citta-spedizione"));
        acquistoBean.setdataAcquisto(LocalDate.now());
        acquistoBean.setnCarta(Integer.parseInt(req.getParameter("numCarta")));
        acquistoBean.setCap(Integer.parseInt(req.getParameter("cap-spedizione")));
        acquistoBean.setVia(req.getParameter("via-spedizione"));
        AcquistoDAO adao = new AcquistoDAO();
        ProdottiDAO pdao = new ProdottiDAO();
        try {
        	adao.inserisciOrdine(acquistoBean);
        	req.getSession().removeAttribute("carrello");
            System.out.println(carrelloCheckout);
            for (OrdineCopia o : carrelloCheckout.viewCart()) {
            		pdao.UpdateCopia(o, acquistoBean);	//si ricava l'ID di una singola copia e poi si pu� fare l'aggiornamento
          }
        }
        catch (Exception e) {e.printStackTrace();}
    	RequestDispatcher rd = req.getServletContext().getRequestDispatcher("/utenteLoggato/account.jsp");
        rd.forward(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}
}