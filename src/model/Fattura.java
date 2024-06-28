package model;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import model.beans.AcquistoBean;
import model.beans.ClienteBean;


public class Fattura {
	private final float rientroX = 32.314f;
	private final float inizioTabella = 455.045f;
	private final float righeTabella[] = {368.5f, 396.85f,425.196f,453.543f,481.889f};
	private String pathTemplate = "C:/Users/Alessandro/git/Progetto-TSW-GDB-Games/WebContent/pdf/template fattura.pdf";
	private String path = "C:/Users/Alessandro/git/Progetto-TSW-GDB-Games/WebContent/pdf/fattura ";
	
	
	private void scriviDescrizione (String titoloVideogioco, String nomeConsole, PDPageContentStream stream, PDPage pagina, float offsetRiga) throws IOException{
		String descrizione = titoloVideogioco + ", "+ nomeConsole;
		int lunghezza = descrizione.length();
		System.out.println(lunghezza);
		int righe = lunghezza / 50;
		int finale = righe * 50;
		int offset = 0;
		stream.beginText();
		if (lunghezza < 32) {		//rimpicciolisce grandezza font in base alla lunghezza della descrizione
			stream.setFont(PDType1Font.HELVETICA, 10);
		}
		else if (lunghezza < 64) {
			stream.setFont(PDType1Font.HELVETICA, 9);
		}
		else {
			stream.setFont(PDType1Font.HELVETICA, 8);
		}
		stream.newLineAtOffset(rientroX + 100, offsetRiga);
		while (offset < righe) {
			int lower = offset * 50;
			int upper = offset * 50 + 50;
			stream.showText(descrizione.substring(lower, upper));
			++offset;
			stream.newLineAtOffset(0, - 10f);
		}
		stream.showText(descrizione.substring(finale));
		stream.endText();
	}
	private void scriviPrimaIntestazione (LocalDate data, int nFattura, PDPageContentStream stream, PDPage pagina) throws IOException{
		float altezza = pagina.getCropBox().getHeight();
		stream.beginText();
		stream.setFont(PDType1Font.HELVETICA, 11);
		stream.newLineAtOffset(rientroX, altezza - 125.212f);
		stream.showText(data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
		stream.newLineAtOffset(rientroX + 149.425f, 0);
		stream.showText(Integer.toString(nFattura));
		stream.endText();
	}
	private void scriviIntestazioneIndirizzo (AcquistoBean acquisto, int nFattura, PDPageContentStream stream, PDPage pagina) throws IOException {
		float altezza = pagina.getCropBox().getHeight();
		stream.beginText();
		stream.setFont(PDType1Font.HELVETICA, 11);
		stream.newLineAtOffset(rientroX, altezza - 210f);
		stream.showText(acquisto.getVia());
		stream.newLineAtOffset(0, -14f);
		stream.showText(acquisto.getCitta() + ", " + acquisto.getCap());
		stream.newLineAtOffset(0, -14f);
		stream.showText(Integer.toString(nFattura));
		stream.endText();
	}
	private void scriviTabellaFinale (float iva, float totale, PDPageContentStream stream, PDPage pagina) throws IOException{
		float OffsetTabellaX = 453f;
		float OffsetTabellaY = 198;
		stream.beginText();
		stream.setFont(PDType1Font.HELVETICA, 11);
		stream.newLineAtOffset(OffsetTabellaX, OffsetTabellaY);
		stream.showText(Float.toString(iva)+"%");
		stream.newLineAtOffset(0, -14.5f);
		stream.showText(Float.toString(totale)+"€");
		stream.endText();
	}
	private void scriviTabellaCentrale (PDPageContentStream stream, PDPage pagina, ArrayList<OrdineCopia> ordini) throws IOException {
		stream.beginText();
		stream.setFont(PDType1Font.HELVETICA, 11);
		stream.newLineAtOffset(rientroX, inizioTabella);
		int cont = 0;
		int temp = ordini.size();
		while (cont < temp)
		{
		OrdineCopia ord = ordini.get(cont);
		stream.showText(Integer.toString(ord.getQuantità()));
		scriviDescrizione(ord.getTitoloVideogioco(), ord.getNomeConsole(), stream, pagina, righeTabella[cont]);
		stream.newLineAtOffset(150, 0);
		stream.showText(Float.toString(ord.getPrezzo()));
		stream.newLineAtOffset(230, 0);
		stream.showText(Float.toString(ord.getPrezzoTotale()));
		stream.newLineAtOffset(0, 14*3);
		stream.endText();
		cont++;
		}
	}
	private void scriviPagina (PDDocument documento, int NPagina, ArrayList<OrdineCopia> ordini, AcquistoBean acquisto) throws IOException{
		PDPage pagina = documento.getPage(NPagina);
		PDPageContentStream stream = new PDPageContentStream(documento, pagina, PDPageContentStream.AppendMode.APPEND, true);
		scriviPrimaIntestazione(acquisto.getdataAcquito(), acquisto.getnFattura(), stream, pagina);
		//scriviTabellaCentrale (stream, pagina, ordini);								//per scrivere tutte le parti della fattura
		scriviTabellaFinale (ordini.get(0).getPercIva(),(float) ordini.stream().mapToDouble(OrdineCopia::getPrezzoTotale).sum(), stream, pagina);
		System.out.println("fattura creata");
		stream.close();
	}
	
	public void creaFattura (int id, ClienteBean cliente) throws IOException, SQLException{
		File temp = new File (path+ id+".pdf");
		if (temp.exists()) return; //se il file esiste termina così non viene ricreato
		
		else {
			AcquistoDAO adao = new AcquistoDAO();
			ProdottiDAO pdao = new ProdottiDAO();
			AcquistoBean acquisto = adao.leggiDaId(id);
			PDDocument documento = PDDocument.load(new File (pathTemplate));
			ArrayList <OrdineCopia> ordini = pdao.leggiDaNFattura(acquisto);
			int nPagine = ordini.size()/5;
			int cont = 0;
			int finale = nPagine * 5;
			int offset = 0;
			while (cont < nPagine){ 
				int lower = offset * 5;
				int upper = offset * 5 + 5;
				scriviPagina(documento, cont, (ArrayList <OrdineCopia>)ordini.subList(lower, upper), acquisto);
				offset++;
			}
			scriviPagina (documento, ++cont, (ArrayList <OrdineCopia>)ordini.subList(finale, ordini.size()), acquisto);
			documento.save(temp);
		}
				
	} 
}