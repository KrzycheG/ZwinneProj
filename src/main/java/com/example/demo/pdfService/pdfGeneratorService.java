package com.example.demo.pdfService;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
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

        Paragraph tytul = new Paragraph("FAKTURA",fontTitle);
        tytul.setAlignment(Paragraph.ALIGN_CENTER);

        Font fontParagraph = FontFactory.getFont(FontFactory.TIMES);
        fontParagraph.setSize(12);

        Font fontBold = FontFactory.getFont(FontFactory.TIMES_BOLD);
        fontBold.setSize(10);

        Paragraph nadawca = new Paragraph("Dane nadawcy:",fontBold);
        nadawca.setAlignment(Paragraph.ALIGN_LEFT);

        String daneNadawcy =
                "\nTWOJA KSIAZKA\n"+
                "ul. Mariacka 2\n"+
                "Katowice 40-132\n"+
                "NIP: 9348539234\n";

        Paragraph paraDane = new Paragraph(daneNadawcy,fontParagraph);
        paraDane.setAlignment(Paragraph.ALIGN_LEFT);



        document.add(tytul);
        document.add(nadawca);
        document.add(paraDane);
        document.close();
    }
}
