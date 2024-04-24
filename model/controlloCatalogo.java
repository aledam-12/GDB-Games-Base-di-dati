package modello;
import beans.*;
import java.io.IOException;
import java.sql.SQLException;

	import javax.servlet.RequestDispatcher;
	import javax.servlet.ServletException;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	public class controlloCatalogo extends HttpServlet 
	{    ProdottiDAO pdao = new ProdottiDAO();
		private static final long serialVersionUID = 1L;

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	        {
	            String action = request.getParameter("action");
			    try {
				    if (action != null) 
	                    {
					        if (action.equalsIgnoreCase("read")) 
	                            {
						           String titolo = request.getParameter("id");
						            request.removeAttribute("copia");
						            request.setAttribute("copia", pdao.trovaprod(titolo));
						            RequestDispatcher disp = request.getRequestDispatcher("catalogo.jsp");
						            disp.forward(request,response);
	                            }
	                    }
	                }
			    catch (Exception e) {
			    	e.printStackTrace();
			    }
			
	        }
		
	}
