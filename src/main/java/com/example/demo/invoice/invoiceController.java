package com.example.demo.invoice;

import com.example.demo.book.book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path="api/v1/book/invoice")
public class invoiceController {

    final InvoiceService invoiceService;

    @Autowired
    public invoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }
    @GetMapping
    public List<invoice> getinvoices(){
        return invoiceService.getinvoices();
    }

    @PostMapping(path = "/add")
    public void addNewInvoice(@RequestBody invoice Invoice){

        invoiceService.addNewInvoice(Invoice);
    }

}
