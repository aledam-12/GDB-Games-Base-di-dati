package control;
import java.sql.SQLException;
import java.util.ArrayList;

import model.OrdineCopia;
import model.ProdottiDAO;

public class Carrello {
ProdottiDAO pdao;
private ArrayList <OrdineCopia> prodotti;
	public Carrello() {
	pdao = new ProdottiDAO();
	prodotti = new ArrayList <OrdineCopia>();
	}	
	public void addToCart (OrdineCopia copia, int quantità) throws SQLException {
		if (pdao.getQuantità(copia) >= copia.getQuantità() && quantità <= 10) copia.setQuantità(quantità);
		else copia.setQuantità(pdao.getQuantità(copia));
		prodotti.add(copia);
	}
	public void removeFromCart (OrdineCopia copia) {
		prodotti.remove(copia);
	}
	public ArrayList <OrdineCopia> viewCart() {
		return prodotti;
	}
	public double getPrezzoTotale() {
		return prodotti.stream().mapToDouble(OrdineCopia::getPrezzoTotale).sum();
	}
	public int getTotaleQuantità() {
		return prodotti.stream().mapToInt(OrdineCopia::getQuantità).sum();
	}
} 