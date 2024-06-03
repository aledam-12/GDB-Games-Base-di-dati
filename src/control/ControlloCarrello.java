package control;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;

import model.OrdineCopia;
import model.ProdottiDAO;


public class ControlloCarrello extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response){
		ProdottiDAO pdao = new ProdottiDAO();
		Carrello cart = (Carrello) request.getSession().getAttribute("carrello");
		if (cart == null) {
			cart = new Carrello();
			request.getSession().setAttribute("carrello", cart);
		} 
		String action = request.getParameter("action");
		if (action.equals("add") && action != null) {
			try { int quantità = 1;
			if(request.getParameter("quantita") != null) quantità = Integer.parseInt(request.getParameter("quantita"));
			int id = Integer.parseInt(request.getParameter("id"));
			OrdineCopia temp = new OrdineCopia(quantità,pdao.leggiCopia(id));
			if (cart.viewCart().contains(temp)) {
				cart.removeFromCart(temp);
				cart.addToCart(temp, quantità);
				request.getSession().setAttribute("carrello", cart);
				RequestDispatcher view = request.getServletContext().getRequestDispatcher("/carrello.jsp");
				view.forward(request, response);
			}
			else {
			cart.addToCart(temp, quantità);
			request.getSession().setAttribute("carrello", cart);
			RequestDispatcher view = request.getServletContext().getRequestDispatcher("/catalogo.jsp");
			view.forward(request, response);}
				}
			catch (Exception e) {
				e.printStackTrace();}
		}
		if (action.equals("view")) {
			request.getSession().setAttribute("prodottiCarrello", cart.viewCart());
			try {
			RequestDispatcher view = request.getServletContext().getRequestDispatcher("/carrello.jsp");
			view.forward(request, response);
			}
			catch (Exception e) {System.out.println("errore nell'inoltro richiesta");}
		}
		if (action.equals("remove")) {
			int id = Integer.parseInt(request.getParameter("id"));
			try {
				cart.removeFromCart(new OrdineCopia(pdao.leggiCopia(id)));
				request.getSession().setAttribute("carrello",cart);
				RequestDispatcher view = request.getServletContext().getRequestDispatcher("/carrello.jsp?action=view");
				view.forward(request, response);
			} 
			catch (Exception e) {e.printStackTrace();} }
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {doGet(request,response);}
}
