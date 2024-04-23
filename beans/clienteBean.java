package beans;
import java.io.Serializable;

public class clienteBean implements Serializable 
{
    private static final long serialVersionUID = 1L;

    String email;
    String nome;
    String cognome;
    String pw;

    public clienteBean()
        {
            email = " ";
            nome = " ";
            cognome = " ";
            pw = " ";
        }

    public String getEmail()    
        {
            return email;
        }
    public void setEmail(String email)
        {
            this.email = email;
        }
    
    public String getNome()
        {
            return nome;
        }
    public void setNome(String nome)
        {
            this.nome = nome;
        }

    public String getCognome()
        {
            return cognome;
        }
    public void setCognome(String cognome)
        {
            this.cognome = cognome;
        }

    public String getPw()   
        {
            return pw;
        }
    public void setpw()
        {
            this.pw = pw;
        }

    @Override
    public String toString()
        {
            return email + ", " + nome + ", " + cognome +", " + pw;
        }
}