package com.example.demo.pdf;

import com.example.demo.book.book;
import com.example.demo.cart.cartController;
import com.example.demo.cart.cartRepository;
import com.example.demo.invoice.invoice;
import com.example.demo.invoice.invoiceController;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Service
public class pdfGeneratorService {

    invoiceController invoiceController;

    cartController cartController;
    cartRepository cartRepository;
    @Autowired
    public pdfGeneratorService(invoiceController invoiceController,cartController cartController,cartRepository cartRepository) {
        this.invoiceController = invoiceController;
        this.cartController=cartController;
        this.cartRepository = cartRepository;
    }




    public void export(HttpServletResponse response) throws IOException {

        List<invoice> invoiceList=invoiceController.getinvoices();

        List<book> cartList=cartController.cartAllBooks();

        int n=invoiceList.size()-1;
        String zipCode=invoiceList.get(n).getZipCode().toString();


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
        tableDane.addCell(new Phrase(invoiceList.get(n).getFirstName()+" "+invoiceList.get(n).getLastName(), fontNormal));
        tableDane.addCell(new Phrase("ul. Mariacka 2", fontNormal));
        tableDane.addCell(new Phrase("ul. "+invoiceList.get(n).getStreet()+" "+invoiceList.get(n).getHouseNumber()+"/"+invoiceList.get(n).getApartmentNumber(), fontNormal));
        tableDane.addCell(new Phrase("Katowice 41-123", fontNormal));
        tableDane.addCell(new Phrase(invoiceList.get(n).getCity()+" "+zipCode.substring(0,2)+'-'+zipCode.substring(2), fontNormal));
        tableDane.addCell(new Phrase("NIP: 9348539234", fontNormal));
        tableDane.addCell(new Phrase(invoiceList.get(n).getCountry(), fontNormal));
        tableDane.addCell(new Phrase("", fontNormal));
        tableDane.addCell(new Phrase("\n", fontNormal));



//        tabela z zawartoscia koszyka:

        float[] columnDefinitionSize2 = { 1f,7f,2f};
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
        table.addCell(new Phrase("id", fontBold));
        table.addCell(new Phrase("nazwa produktu", fontBold));
        table.addCell(new Phrase("cena", fontBold));

//        table.addCell(new Phrase(cartList.get(0).getId().toString(), fontNormal));
//        table.addCell(new Phrase(cartList.get(0).getTitle(), fontNormal));
//        table.addCell(new Phrase(Double.toString(cartList.get(0).getPrice()), fontNormal));

        double suma=0;

        for (int i = 0; i < cartList.size(); i++) {
            table.addCell(new Phrase(cartList.get(i).getId().toString(), fontNormal));
            table.addCell(new Phrase(cartList.get(i).getTitle(), fontNormal));
            table.addCell(new Phrase(Double.toString(cartList.get(i).getPrice())+ " PLN", fontNormal));
            suma+=cartList.get(i).getPrice();
        }

        PdfPCell sum=null;

        sum = new PdfPCell(new Phrase("Suma: " + suma + " PLN",fontBoldBig));
        sum.setColspan(columnDefinitionSize2.length);
        sum.setHorizontalAlignment(2);

       table.addCell(sum);


        document.add(tytul);//FAKTURA
        //document.add(paraDane);
        document.add(tableDane);//zawiera dane nadawcy oraz odbiorcy
        document.add(table);

        document.close();

        cartRepository.deleteAll();
    }
}
