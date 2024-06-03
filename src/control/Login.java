package control;

import javax.servlet.annotation.WebServlet;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.http.*;

import model.ClienteDAO;
import model.beans.ClienteBean;
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String redirectedPage = "/Login.jsp";
        try {  
        	HttpSession session = req.getSession();
            ClienteDAO ClienteDAO = new ClienteDAO();

            boolean feedback;
            boolean cambioForm;

            ClienteBean cliente = ClienteDAO.leggiCliente(username);
        	if (ClienteDAO.isRegistrato(cliente)) { //mail check
                if(checkUser(cliente, toHash(password), session)){ //pass check
                    if (cliente.getStato().equals("admin")) redirectedPage = "/admin/admin.jsp";
                	redirectedPage = "/catalogo.jsp";
                    feedback = true;
                    session.setAttribute("feedback", feedback);}

                else{
               

                    feedback = false;
                    cambioForm = false;

                    session.setAttribute("feedback", feedback);
                    session.setAttribute("cambioForm", cambioForm);
                    

                }   
            }
        	else{
                                
                feedback = false; 
                cambioForm = true;

                session.setAttribute("feedback", feedback);
                session.setAttribute("cambioForm", cambioForm);
            }
            
            
            RequestDispatcher rd = getServletContext().getRequestDispatcher(redirectedPage);
            rd.forward(req, resp);
            }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean checkUser(ClienteBean cliente, String password, HttpSession session) throws SQLException {
        if (cliente == null || !(cliente.getPw().equals(password)))
            return false;
        else {
            
        session.setAttribute("auth", cliente.getStato());
        session.setAttribute("cliente", cliente);
        session.setAttribute("nomeCliente", cliente.getNome());

        return true;
        }
    }

    private String toHash(String password) {		//metodo per criptare la password
    	String hashString = null;
    	try {
    		java.security.MessageDigest digest = java.security.MessageDigest.getInstance("SHA-512");
    		byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
    		hashString = "";
    		for (int i = 0; i < hash.length; i++) {
    			hashString += Integer.toHexString(
    					(hash[i] & 0xFF) | 0x100).toLowerCase().substring(1,3); 
    		}
    	} catch (java.security.NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
    	return hashString;
    }
}