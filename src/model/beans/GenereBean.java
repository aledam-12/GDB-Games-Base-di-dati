package model.beans;
import java.io.Serializable;

public class GenereBean implements Serializable
{
    private static final long serialVersionUID = 1L;
    String genere;

    public GenereBean()
        {
            genere = " ";
        }

    public String getGenere()
        {
            return genere;
        }
    public void setGenere(String genere)
        {
            this.genere = genere;
        }
    
    @Override
    public String toString()
        {
            return genere;
        }
}