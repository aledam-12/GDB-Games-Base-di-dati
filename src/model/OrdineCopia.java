package model;
import java.io.Serializable;

import model.beans.copiaBean;
public class OrdineCopia extends copiaBean implements Serializable  {
	private static final long serialVersionUID = 1L;
	private int quantit�;
public int getQuantit�() {
	return this.quantit�;
}
public void setQuantit� (int q) {
	if (q < 0) return;
	else this.quantit� = q;
}
	public OrdineCopia (int quantit�, copiaBean a) {
	super();
	setCodiceAcquisto(a.getCodiceAcquisto());
	setCodiceCopia(a.getCodiceCopia());
	setTitoloVideogioco(a.getTitoloVideogioco());
	setNomeConsole(a.getNomeConsole());
	setPrezzo(a.getPrezzo());
	setStato(false);
	setPercIva(a.getPercIva());
	setQuantit�(quantit�);
	}
	public OrdineCopia (copiaBean a) {
	super();
	setCodiceAcquisto(a.getCodiceAcquisto());
	setCodiceCopia(a.getCodiceCopia());
	setTitoloVideogioco(a.getTitoloVideogioco());
	setNomeConsole(a.getNomeConsole());
	setPrezzo(a.getPrezzo());
	setStato(false);
	setPercIva(a.getPercIva());
	}
	public float getPrezzoTotale() {
		float iva = this.getPercIva()/100 * this.getPrezzo();
		return (this.getPrezzo()+iva)*quantit�;
	}
    @Override
    public boolean equals(Object b) {		
    	if (b==null) return false;
    	if (b.getClass() != this.getClass()) return false;
    	OrdineCopia altraCopia = (OrdineCopia) b;
    	if (this.getCodiceCopia() == altraCopia.getCodiceCopia()) return true;
    	else {
    		if (this.getNomeConsole().equals(altraCopia.getNomeConsole())&&
    				this.getTitoloVideogioco().equals(altraCopia.getTitoloVideogioco()))
    		return true;
    		else return false;
    	}
    }
}
