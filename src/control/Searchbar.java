package control;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import model.OrdineCopia;
import model.ProdottiDAO;

@WebServlet("/Searchbar")
public class Searchbar extends HttpServlet {
    
	private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String search = req.getParameter("search");
        String console = req.getParameter("console");
        System.out.println("console ="+console);
        System.out.println("search ="+search);
        ProdottiDAO pdao = new ProdottiDAO();
        ArrayList<OrdineCopia> prodotti = new ArrayList<>();
		try {
			prodotti = pdao.cercaProdotti(search, console);
			req.setAttribute("prodottiCercati", prodotti);
			JSONArray jArray = new JSONArray();
			if (prodotti.size() == 0) {
				JSONObject jsonObject = new JSONObject();
			    jsonObject.put("titolo", "Nessun risultato");
			    jsonObject.put("prezzo", "-");
			    jsonObject.put("console", "-");
			    jsonObject.put("quantita", "-");
			    jArray.put(jsonObject);
			}
			else {for (OrdineCopia prod : prodotti) {
			    JSONObject jsonObject = new JSONObject();
			    jsonObject.put("titolo", prod.getTitoloVideogioco());
			    jsonObject.put("prezzo", prod.getPrezzo());
			    jsonObject.put("console", prod.getNomeConsole());
			    jsonObject.put("quantita", Integer.toString(prod.getQuantità()));
			    jArray.put(jsonObject);
			}}
	        resp.setContentType("application/json");
	        resp.setCharacterEncoding("UTF-8");

	        PrintWriter out = resp.getWriter();
	        out.print(jArray.toString());
	        out.flush();
		} catch (SQLException e) {
			e.printStackTrace();
		}
        	
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doPost(req,resp);
    }
}