package com.example.demo.invoice;


import com.example.demo.book.book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {

    final invoiceRepository InvoiceRepository;

    @Autowired
    public InvoiceService(invoiceRepository invoiceRepository) {
        InvoiceRepository = invoiceRepository;
    }

    public List<invoice> getinvoices(){

        return InvoiceRepository.findAll();
    }


    public void addNewInvoice(invoice invoice) {

        Optional<invoice> invoiceOptional =  InvoiceRepository.
                findByLastName((invoice.getLastName()));


        if(invoiceOptional.isPresent()){

            throw new IllegalStateException(" invoice jest w repo");
        }
        InvoiceRepository.save(invoice);
        System.out.println(invoice);
    }
}
