package: model;
import model.beans.videogiocobean.java;
import model.beans.copiabean.java;
import java..sql.SQLException;
import java.util.Collection;

public interface Prodotti
{
    public void inserisciprod(videogiocobean v) throws SQLException;
    public void inscopia(copiabean copia) throws SQLException;

    public boolean cancellaprod(String titolo) throws SQLException;
    public boolean cancellacopia(String titolovideogioco) throws SQLException;

    public copiabean trovaprod(String videogioco) throws SQLException;
    public Collection<copiabean> seltutti(String ordine) throws SQLException;

    public void modificaprod(String m, Int p) throws SQLException;
    public void modificaprod(String m, String d) throws SQLException;
    public void modificaprod(String m, String d, Int p) throws SQLException;

    public void modificacopia(String m, Int s) throws SQLException;
    public void modificacopia(String m, Float iva) throws SQLException;
    public void modificacopia(String m, Float pre) throws SQLException;
    public void modificacopia(String m, Int s, Float iva) throws SQLException;
    public void modificacopia(String m, Int s, Float pre) throws SQLException;
    public void modificacopia(String m, Float iva, Float pre) throws SQLException;
    public void modificacopia(String m, Int s, Float iva, Float pre) throws SQLException;
}