package: model.beans;
import java.io.Serializable;

public class generebean implements Serializable
{
    private static final long serialVersionUID = 1L;

    String nome;

    public generebean()
        {
            nome = " ";
        }

    public getgenere()
        {
            return genere;
        }
    public String setgenere(String genere)
        {
            this.genere = genere;
        }
    
    @Override
    public String ToString()
        {
            return genere;
        }
}