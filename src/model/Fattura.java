package model;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import model.beans.AcquistoBean;

public class Fattura {
	private static final float rientroX = 32.314f;
	private static final float rientroY = 72f;
	private static final float spazioRiga = 3f;
	private static final float fontSize = 15f;
	private static final float inizioTabella = 455.045f;
	private static String pathTemplate = "C:/Users/Alessandro/Desktop/unisa/anno 2/Teconologie Software Web/esercizi e programmi (workspace tsw)/GDBGames/WebContent/pdf/template fattura.pdf";
	private static String path = "C:/Users/Alessandro/Desktop/unisa/anno 2/Teconologie Software Web/esercizi e programmi (workspace tsw)/GDBGames/SQL code/prova.pdf";
	
	private void scriviPrimaIntestazione (AcquistoBean acquisto, PDPageContentStream stream, PDPage pagina) throws IOException{
		float altezza = pagina.getCropBox().getHeight();
		stream.beginText();
		stream.setFont(PDType1Font.HELVETICA, 11);
		stream.newLineAtOffset(rientroX, altezza - 125.212f);
		stream.showText(acquisto.getdataAcquito().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
		stream.newLineAtOffset(rientroX + 149.425f, 0);
		stream.showText(Integer.toString(acquisto.getnFattura()));
		stream.endText();
	}
	private void scriviIntestazioneIndirizzo (AcquistoBean acquisto, PDPageContentStream stream, PDPage pagina) throws IOException {
		float altezza = pagina.getCropBox().getHeight();
		stream.beginText();
		stream.setFont(PDType1Font.HELVETICA, 11);
		stream.newLineAtOffset(rientroX, altezza - 210f);
		stream.showText(acquisto.getVia());
		stream.newLineAtOffset(0, -14f);
		stream.showText(acquisto.getCitta());
		stream.newLineAtOffset(0, -14f);
		stream.showText(Integer.toString(acquisto.getCap()));
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
	
	//manca parte centrale della tabella
	public void creaFattura (AcquistoBean acquisto, ArrayList<OrdineCopia> copie) throws IOException{
			try {
				float PrezzoTotale = (float) copie.stream().mapToDouble(OrdineCopia::getPrezzoTotale).sum();
				PDDocument documento = PDDocument.load(new File(pathTemplate));
				PDPage pagina = documento.getPage(0);
				float altezza = pagina.getCropBox().getHeight();
				float larghezza = pagina.getCropBox().getWidth();
				PDPageContentStream stream = new PDPageContentStream(documento, pagina, PDPageContentStream.AppendMode.APPEND, true);
				scriviPrimaIntestazione(acquisto, stream, pagina);
				scriviIntestazioneIndirizzo (acquisto, stream, pagina);
				scriviTabellaFinale(copie.get(0).getPercIva(), PrezzoTotale, stream, pagina);
				/* stream.beginText();
				stream.setFont(PDType1Font.HELVETICA, 11);
				System.out.println("Scrivo a: "+ rientroX + ", "+inizioTabella);
				stream.newLineAtOffset(rientroX, inizioTabella);
				stream.showText("AAAAAAAAAAAA");
				System.out.println("Scrivo a: "+ rientroX+100 + ", "+inizioTabella);
				stream.newLineAtOffset(rientroX+90, 0);
				stream.showText("BBBBBBBBBBBBBB");
				stream.endText(); */
				stream.close();
				documento.save(new File(path));
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
}
