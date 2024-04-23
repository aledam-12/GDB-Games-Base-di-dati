package: model.beans;
import java.io.Serializable;

public class videogiocobean implements Serializable
{
    private static final long serialVersionUID = 1L;

    String titolo;
    String descrizione;
    int pegi;

    public videogiocobean()
        {
            titolo = " ";
            descrizione = " ";
            prgi = 0;
        }

    public gettitolo()
        {
            return titolo;
        }
    public String settitolo(String titolo)
        {
            this.titolo = titolo;
        }

    public getdescrizione()
        {
            return descrizione;
        }
    public String setdescrizione(String descrizione)
        {
            this.descrizione = descrizione;
        }

    public getpegi()
        {
            return pegi;
        }
    public int setpegi(int pegi)
        {
            this.pegi = pegi;
        }

    @Override
    public String ToString()
        {
            return console + ", " + titolo + ", " + descrizione + ", " pegi;
        }
}