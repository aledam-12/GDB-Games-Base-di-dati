package: model.beans;
import java.io.Serializable;
import java.time.LocalDate;

public class reclamobean implements Serializable
{
    private static final long serialVersionUID = 1L;

    LocalDate datareclamo;
    int nreclamo;
    String titolo;
    String contenuto;
    String emailCliente;

    public reclamobean()
        {
            datareclamo = LocalDate.of(1999,1,1);
            nreclamo = 0;
            titolo = " ";
            contenuto = " ";
            emailCliente = " ";
        }
    
    public getdatareclamo()
        {
            return datareclamo;
        }
    public LocalDate setdatareclamo(LocalDate datareclamo)
        {
            this.datareclamo = datareclamo;
        }
    
    public getnreclamo()
        {
            return nreclamo;
        }
    public int setnreclamo(int nreclamo)
        {
            this.nreclamo = nreclamo;
        }
    
    public gettitolo()
        {
            return titolo;
        }
    public String settitolo(String titolo)
        {
            this.titolo = titolo;
        }

    public getcontenuto()
        {
            return contenuto;
        }
    public String setcontenuto(String contenuto)
        {
            this.contenuto = contenuto;
        }

    public getemailCliente()
        {
            return emailCliente;
        } 
    public String setemailCliente(String emailCliente)
        {
            this.emailCliente = emailCliente;
        }
    
    @Override
    public String ToString()
        {
            return datareclamo + ", " + nreclamo + ", " + titolo + ", " + contenuto + ", " + emailCliente;           
        }
}