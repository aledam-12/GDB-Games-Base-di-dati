package: model.beans;
import java.io.Serializable;
import java.time.LocalDate;

public class acquistobean implements Serializable   
{
    private static final long serialVersionUID = 1L;

    String emailcliente;
    Int ncarta;
    int nfattura;
    LocalDate dataAcquisto;
    String via;
    int cap;
    String citta;
    float prezzototale;

    public acquistobean()
        {
            emailcliente = " ";
            ncarta = 0;
            nfattura = 0;
            dataAcquisto = LocalDate.of(1999,1,1);
            via = " ";
            cap = 0;
            citta = " ";
            prezzototale = 0.0;
        }

    public getemailcliente()
        {
            return emailcliente;
        }
    public setemailcliente(String emailcliente)
        {
            this.emailcliente = emailcliente;
        }

    public getncarta()
        {
            return ncarta;
        }
    public setncarta(Int ncarta)
        {
            this.ncarta = ncarta;
        }

    public getnfattura()
        {
            return nfattura;
        }
    public int setnfattura()
        {
            this.nfattura = nfattura;
        }

    public getdataAcquito()
        {
            return dataAcquisto;
        }
    public LocalDate setdataacquisto(LocalDate dataAcquisto)
        {
            this.dataAcquisto = dataAcquisto;
        }

    public getvia()
        {
            return via;
        }
    public String setvia(String via)
        {
            this.via = via;
        }

    public getcap()
        {
            return cap;
        }
    public int setcap(int cap)
        {
            this.cap = cap;
        }

    public getcitta()
        {
            return citta;
        }   
    public String setcitta(String citta)
        {
            this.citta = citta;
        }
    
    public getprezzototali()
        {
            return prezzototale;
        }
    public float set prezzototale(float prezzototale)  
        {
            this.prezzototale = prezzototale;
        }

    @Override
    public String ToString()
        {
            return nfattura + ", " + dataAcquisto + ", " + via + ", " + cap + ", " + citta + ", " + prezzototale; 
        }
}