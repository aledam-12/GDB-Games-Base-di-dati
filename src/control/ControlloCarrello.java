package control;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;

import model.Carrello;
import model.OrdineCopia;
import model.ProdottiDAO;
import model.beans.CopiaBean;

import org.json.*;

public class ControlloCarrello extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
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
        	String titolo = request.getParameter("titolo");
        	String console = request.getParameter("console");
        	float prezzo = Float.parseFloat(request.getParameter("prezzo"));
        	CopiaBean copiaTemp = new CopiaBean();
        	copiaTemp.setNomeConsole(console);
        	copiaTemp.setTitoloVideogioco(titolo);
        	copiaTemp.setPrezzo(prezzo);
			OrdineCopia temp = new OrdineCopia(quantità,copiaTemp);
			if (cart.viewCart().contains(temp)) {
                cart.removeFromCart(temp);
				cart.addToCart(temp, quantità); 
    //json build 
                ArrayList<OrdineCopia> prodotti = cart.viewCart();
                
				JSONArray jArray = new JSONArray();
                for (OrdineCopia prod : prodotti) {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("titolo", prod.getTitoloVideogioco());
			        jsonObject.put("prezzo", prod.getPrezzo());
			        jsonObject.put("console", prod.getNomeConsole());
			        jsonObject.put("quantita", Integer.toString(prod.getQuantità()));
			        jArray.put(jsonObject);
                
                }
    		request.getSession().removeAttribute("carrello");
            request.getSession().setAttribute("carrello", cart);


    		response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        PrintWriter out = response.getWriter();
	        out.print(jArray.toString());
	        out.flush();

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
			RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/carrello.jsp");
			rd.forward(request, response);
			}
			catch (Exception e) {e.printStackTrace();}
		}
		if (action.equals("remove")) {
        	String titolo = request.getParameter("titolo");
        	String console = request.getParameter("console");
        	float prezzo = Float.parseFloat(request.getParameter("prezzo"));
        	CopiaBean copiaTemp = new CopiaBean();
        	copiaTemp.setNomeConsole(console);
        	copiaTemp.setTitoloVideogioco(titolo);
        	copiaTemp.setPrezzo(prezzo);
			OrdineCopia temp = new OrdineCopia(copiaTemp);
			try {
				cart.removeFromCart(temp);
				request.getSession().setAttribute("carrello",cart);
				RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/carrello.jsp?action=view");
				rd.forward(request, response);
			} 
			catch (Exception e) {e.printStackTrace();} }
    }   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {doGet(request,response);}
}
