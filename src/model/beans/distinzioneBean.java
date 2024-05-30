package model.beans;
import java.io.Serializable;

public class distinzioneBean implements Serializable
{
    private static final long serialVersionUID = 1L;

    String titoloVideogioco;
    String nomeGenere;

    public distinzioneBean()
        {
            titoloVideogioco = " ";
            nomeGenere = " ";
        }

    public String getTitoloVideogioco()
        {
            return titoloVideogioco;
        }
    public void setTitoloVideogioco(String titolovideogioco)
        {
            this.titoloVideogioco = titolovideogioco;
        }

    public String getNomeGenere()
        {
            return nomeGenere;
        }
    public void setNomeGenere(String nomeGenere)
        {
            this.nomeGenere = nomeGenere;
        }

    public String toString()
        {
            return titoloVideogioco + ", " + nomeGenere;
        }
}