package: model;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controllocatalogo extends HttpServlet 
{    
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
        {
            String action = request.getParameter("action");
		    try {
			    if (action != null) 
                    {
				        if (action.equalsIgnoreCase("read")) 
                            {
					            int id = Integer.parseInt(request.getParameter("id"));
					            request.removeAttribute("copia");
					            request.setAttribute("copia", model.doRetrieveByKey(id));
                            }
                    }
                }
        }
}