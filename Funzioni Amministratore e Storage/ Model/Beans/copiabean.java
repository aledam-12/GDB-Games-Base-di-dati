package: model.beans;
import java.io.Serializable;

public class copiabean implements Serializable
{
    private static final long serialVersionUID = 1L;

    int stato;
    float partitaiva;
    float prezzo;
    int codiceCopia;
    int codiceAcquisto;
    String titolovideogioco;
    String nomeconsole;

    public copiabean()
        {
            stato = "0";
            partitaiva = 0.0;
            prezzo = 0.0;
            codiceCopia = 0;
            codiceAcquisto = 0;
            titolovideogioco = " ";
            nomeconsole = " ";
        }

            public getstato()
                {
                    return stato;
                }
            public int setstato(boolean stato)
                {
                    this.stato = stato;
                }

            public getpartitaiva()
                {
                    return partitaiva;
                }
            public float setpartitaiva(float partitaiva)
                {
                    this.partitaiva = partitaiva;
                }

            public getprezzo()
                {
                    return prezzo;
                }
            public float setprezzo(float prezzo)
                {
                    this.prezzo = prezzo;
                }

            public getcodiceCopia()
                {
                    return codiceCopia;
                }
            public int setcodiceCopia(int codiceCopia)
                {
                    this.codiceCopia = codiceCopia;
                }

            public getcodiceAcquisto()
                {
                    return codiceAcquisto;
                }
            public int setcodiceAcquisto(int codiceAcquisto)
                {
                    this.codiceAcquisto = codiceAcquisto;
                }

            public gettitolovideogioco()
                {
                    return titolovideogioco;
                }
            public String settitolovideogioco(String titolovideogioco)
                {
                    this.titolovideogioco = titolovideogioco;
                }

            public getnomeconsole()
                {
                    return nomeconsole;
                }
            public String setnomeconsole(String nomeconsole)
                {
                    this.nomeconsole = nomeconsole;
                }
                
            @Override
            public String ToString()
                {
                    return stato + ", " + prezzo + ", " + codiceCopia + ", " + codiceAcquisto + ", " + titolovideogioco + ", " + nomeconsole;
                }
}