package model;
import beans.copiaBean;
import java.sql.SQLException;
import java.util.Collection;
import beans.videogiocoBean;

public interface Prodotti
{
    public void inserisciProd(videogiocoBean v) throws SQLException;
    public void inscopia(copiaBean copia) throws SQLException;

    public boolean cancellaprod(String titolo) throws SQLException;
    public boolean cancellacopia(String titolovideogioco) throws SQLException;

    public copiaBean trovaprod(String videogioco) throws SQLException;
    public Collection<copiaBean> seltutti(String ordine) throws SQLException;

    public void modificaprod(String m, int p) throws SQLException;
    public void modificaprod(String m, String d) throws SQLException;
    public void modificaprod(String m, String d, int p) throws SQLException;

    public void modificaCopia(String m, int s) throws SQLException;
    public void modificaCopia(String m, float iva) throws SQLException;    
    public void modificaCopia(String m, int s, Float iva) throws SQLException;
    public void modificaCopia(String m, Float iva, Float pre) throws SQLException;
    public void modificaCopia(String m, int s, Float iva, Float pre) throws SQLException;
}