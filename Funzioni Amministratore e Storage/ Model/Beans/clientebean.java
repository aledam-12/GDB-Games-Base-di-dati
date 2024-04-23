package: model.beans;
import java.io.Serializable;

public class clientebean implements Serializable 
{
    private static final long serialVersionUID = 1L;

    String email;
    String nome;
    String cognome;
    String pw;

    public clientebean()
        {
            email = " ";
            nome = " ";
            cognome = " ";
            pw = " ";
        }

    public getemail()    
        {
            return email;
        }
    public String setemail(String email)
        {
            this.email = email;
        }
    
    public getnome()
        {
            return nome;
        }
    public String setnome(String nome)
        {
            this.nome = nome;
        }

    public getcognome()
        {
            return cognome;
        }
    public String setcognome(String cognome)
        {
            this.cognome = cognome
        }

    public getpw()   
        {
            return pw;
        }
    public String setpw()
        {
            this.pw = pw;
        }

    @Override
    public String ToString()
        {
            return email + ", " + nome + ", " + cognome +", " + pw;
        }
}