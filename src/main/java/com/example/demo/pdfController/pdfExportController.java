package com.example.demo.pdfController;


import com.example.demo.invoice.InvoiceService;
import com.example.demo.invoice.invoice;
import com.example.demo.invoice.invoiceController;
import com.example.demo.pdfService.pdfGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class pdfExportController {

    private final pdfGeneratorService pdfGeneratorService;

    public pdfExportController(pdfGeneratorService pdfGeneratorService) {
        this.pdfGeneratorService = pdfGeneratorService;
    }

    @GetMapping("/pdf/generate")
    public void generatePDF(HttpServletResponse response) throws IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey="Content-Disposition";
        String headerValue = "attachment; filename=faktura_"+currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);



        this.pdfGeneratorService.export(response);
    }
}
