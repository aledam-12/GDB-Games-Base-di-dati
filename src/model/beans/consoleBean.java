package model.beans;
import java.io.Serializable;

public class consoleBean implements Serializable
{
    private static final long serialVersionUID = 1L;

    String nome;

    public consoleBean()
        {
            nome = " ";
        }
    
    public String getNome()
        {
            return nome;
        }
    public void setNome(String nome)
        {
            this.nome = nome;
        }

    @Override
    public String toString()
        {
            return nome;
        }
}