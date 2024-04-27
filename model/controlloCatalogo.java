package modello;
import java.io.IOException;
import beans.copiaBean;
import java.util.ArrayList;
import java.sql.SQLException;
	import javax.servlet.RequestDispatcher;
	import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	public class controlloCatalogo extends HttpServlet 
	{    
		ProdottiDAO pdao = new ProdottiDAO();
		private static final long serialVersionUID = 1L;

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	        {	String action = request.getParameter("action");
	        try {
				    if (action != null) 
	                    {
					        if (action.equalsIgnoreCase("read")) 
	                            {	int code = Integer.parseInt(request.getParameter("id"));
	                            	String titolo = request.getParameter("titolo");
	                            	request.removeAttribute("copia");
	                            	request.setAttribute("copia",pdao.leggiCopia(code));
	                            	request.removeAttribute("videogioco");
	                            	request.setAttribute("videogioco",pdao.leggiVideogioco(titolo));
						            RequestDispatcher disp = request.getServletContext().getRequestDispatcher("/DettaglioVideogioco.jsp");
						            disp.forward(request,response);
						            return;
	                            }
	                    }
	                }
			    catch (Exception e) {
			    	e.printStackTrace();
			    }
			try {
				request.removeAttribute("copieVideogiochi");
				request.setAttribute("copieVideogiochi",pdao.leggiTutteCopie(""));
			}
		    catch (Exception e) {
		    	e.printStackTrace();
	        }
			RequestDispatcher disp = request.getServletContext().getRequestDispatcher("/catalogo.jsp");
			disp.forward(request,response);
	       }
		protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			doGet(request,response);
		}
		
	}
