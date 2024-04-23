package: model.beans;
import java.io.Serializable;

public class distinzionebean implements Serializable
{
    private static final long serialVersionUID = 1L;

    String titolovideogioco;
    String nomeGenere;

    public distinzionebean()
        {
            titolovideogioco = " ";
            nomeGenere = " ";
        }

    public gettitolovideogioco()
        {
            return titolovideogioco;
        }
    public String settitolovideogioco(String titolovideogioco)
        {
            this.titolovideogioco = titolovideogioco;
        }

    public getnomeGenere()
        {
            return nomeGenere;
        }
    public String setnomeGenere(String nomeGenere)
        {
            this.nomeGenere = nomeGenere;
        }

    public String ToString()
        {
            return titolovideogioco + ", " + nomeGenere;
        }
}