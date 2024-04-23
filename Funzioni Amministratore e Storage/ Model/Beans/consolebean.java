package: model.beans;
import java.io.Serializable;

public class consolebean implements Serializable
{
    private static final long serialVersionUID = 1L;

    String nome;

    public consolebean()
        {
            nome = " ";
        }
    
    public getnome()
        {
            return nome;
        }
    public String setnome(String nome)
        {
            this.nome = nome;
        }

    @Override
    public String ToString()
        {
            return nome;
        }
}