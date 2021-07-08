package com.lina.helper;

import java.awt.Color;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.lina.model.label.FichePaie;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

public class FichePaiePDFExporter {
	private FichePaie fiche;
	public FichePaiePDFExporter(FichePaie p){
		fiche=p;
	}
	private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);
         
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);
         
        cell.setPhrase(new Phrase("Designation", font));
         
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Total Heure", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Taux Horraire", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Montant", font));
        table.addCell(cell);
         
    }
     
    private void writeTableData(PdfPTable table) {
		table.addCell("Nb Heure Jour");
		table.addCell(String.valueOf(fiche.getNbHeureJour()));
		table.addCell(String.valueOf(fiche.getTauxHJour()));
		table.addCell(String.valueOf(fiche.getMontantJour()));
		
		table.addCell("Nb Heure Nuit");
		table.addCell(String.valueOf(fiche.getNbHeureNuit()));
		table.addCell(String.valueOf(fiche.getTauxHNuit()));
		table.addCell(String.valueOf(fiche.getMontantNuit()));
		
		table.addCell("Nb Heure Dimanche");
		table.addCell(String.valueOf(fiche.getNbHeureDimanche()));
		table.addCell(String.valueOf(fiche.getTauxHDimanche()));
		table.addCell(String.valueOf(fiche.getMontantDimanche()));
		
		table.addCell("Nb Heure Férié Travaillé");
		table.addCell(String.valueOf(fiche.getNbHeureFT()));
		table.addCell(String.valueOf(fiche.getTauxHFT()));
		table.addCell(String.valueOf(fiche.getMontantHFT()));
		
		table.addCell("Nb Heure Férié");
		table.addCell(String.valueOf(fiche.getNbHeureF()));
		table.addCell(String.valueOf(fiche.getTauxHF()));
		table.addCell(String.valueOf(fiche.getMontantF()));
		
		table.addCell("Nb Heure Sup 30");
		table.addCell(String.valueOf(fiche.getNbHeureSup30()));
		table.addCell(String.valueOf(fiche.getTauxHS30()));
		table.addCell(String.valueOf(fiche.getMontantHS30()));
		
		table.addCell("Nb Heure Sup 50");
		table.addCell(String.valueOf(fiche.getNbHeureSup50()));
		table.addCell(String.valueOf(fiche.getTauxHS50()));
		table.addCell(String.valueOf(fiche.getMontantHS50()));

		table.addCell("Indemnité");
		table.addCell("");
		table.addCell("");
		table.addCell(String.valueOf(fiche.getIndemnite()));
		
		table.addCell("Total à payer");
		table.addCell("");
		table.addCell("");
		table.addCell(String.valueOf(fiche.getVraiTotal()));
    }
     
    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
         
        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);
         
        Paragraph p = new Paragraph("Fiche de paie", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
         
        document.add(p);

		
        p = new Paragraph("Nom :".concat(this.fiche.getEmploye().getNom()), font);
        p.setAlignment(Paragraph.ALIGN_LEFT);
        document.add(p);
        p = new Paragraph("Prénom :".concat(this.fiche.getEmploye().getPrenom()), font);
        p.setAlignment(Paragraph.ALIGN_LEFT);
        document.add(p);
        p = new Paragraph("N° Matricule :".concat(this.fiche.getEmploye().getMatricule()), font);
        p.setAlignment(Paragraph.ALIGN_LEFT);
        document.add(p);
        p = new Paragraph("Catégorie :".concat(this.fiche.getCategorie().getNomCategorie()), font);
        p.setAlignment(Paragraph.ALIGN_LEFT);
        document.add(p);
         
        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f});
        table.setSpacingBefore(10);
         
        writeTableHeader(table);
        writeTableData(table);
         
        document.add(table);
         
        document.close();
         
    }
	
}
