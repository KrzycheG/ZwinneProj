package com.example.demo.pdfService;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
public class pdfGeneratorService {
    public void export(HttpServletResponse response) throws IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document,response.getOutputStream());

        document.open();
        Font fontTitle= FontFactory.getFont(FontFactory.TIMES);
        fontTitle.setSize(22);

        Paragraph tytul = new Paragraph("FAKTURA\n\n",fontTitle);
        tytul.setAlignment(Paragraph.ALIGN_CENTER);

        Font fontNormal = FontFactory.getFont(FontFactory.TIMES);
        fontNormal.setSize(12);

        Font fontBold = FontFactory.getFont(FontFactory.TIMES_BOLD);
        fontBold.setSize(10);

        Font fontBoldBig = FontFactory.getFont(FontFactory.TIMES_BOLD);
        fontBoldBig.setSize(14);




        //        dane nadawcy i odbiorcy

        float width = document.getPageSize().getWidth();
        float height = document.getPageSize().getHeight();

        float[] columnDefinitionSize = { 5f, 3f};

        float pos = height / 2;

        PdfPTable tableDane = null;
        PdfPCell cellDane = null;

        tableDane = new PdfPTable(columnDefinitionSize);
        tableDane.getDefaultCell().setBorder(0);
        tableDane.setHorizontalAlignment(0);
        tableDane.setTotalWidth(width - 72);
        tableDane.setLockedWidth(true);

        cellDane = new PdfPCell(new Phrase("rachunek"));
        cellDane.setColspan(columnDefinitionSize.length);
        //tableDane.addCell(cellDane);
        tableDane.addCell(new Phrase("Dane nadawcy:", fontBold));
        tableDane.addCell(new Phrase("Dane odbiorcy:", fontBold));
        tableDane.addCell(new Phrase("TWOJA KSIAZKA", fontNormal));
        tableDane.addCell(new Phrase("Imie i nazwisko", fontNormal));
        tableDane.addCell(new Phrase("ul. Mariacka 2", fontNormal));
        tableDane.addCell(new Phrase("ulica i numer", fontNormal));
        tableDane.addCell(new Phrase("Katowice 41-123", fontNormal));
        tableDane.addCell(new Phrase("miasto i kod pocztowy", fontNormal));
        tableDane.addCell(new Phrase("NIP: 9348539234", fontNormal));
        tableDane.addCell(new Phrase("kraj", fontNormal));
        tableDane.addCell(new Phrase("", fontNormal));
        tableDane.addCell(new Phrase("\n", fontNormal));


//        tabela z zawartoscia koszyka:

        float[] columnDefinitionSize2 = { 1f,5f,2f,2f};
        PdfPTable table = null;
        PdfPCell cell = null;
        table = new PdfPTable(columnDefinitionSize2);
        table.getDefaultCell().setBorder(0);
        table.setHorizontalAlignment(0);
        table.setTotalWidth(width - 72);
        table.setLockedWidth(true);

        cell = new PdfPCell(new Phrase("SZCZEGOLY ZAMOWIENIA",fontBoldBig));
        cell.setColspan(columnDefinitionSize2.length);
        cell.setHorizontalAlignment(1);
        table.addCell(cell);
        table.addCell(new Phrase("numer", fontBold));
        table.addCell(new Phrase("nazwa produktu", fontBold));
        table.addCell(new Phrase("ilosc", fontBold));
        table.addCell(new Phrase("cena", fontBold));
        table.addCell(new Phrase("5", fontNormal));
        table.addCell(new Phrase("6", fontNormal));
        table.addCell(new Phrase("7", fontNormal));
        table.addCell(new Phrase("8", fontNormal));


        document.add(tytul);//FAKTURA
        //document.add(paraDane);
        document.add(tableDane);//zawiera dane nadawcy oraz odbiorcy
        document.add(table);

        document.close();
    }
}
