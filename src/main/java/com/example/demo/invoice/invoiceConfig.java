package com.example.demo.invoice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class invoiceConfig {

    @Bean(name = "invoice")
    CommandLineRunner commandLineRunner(
            invoiceRepository repository) {

                return args -> {

                    invoice mariusz = new invoice(11L,
                            "Andrzej",
                            "Marian",
                            "Wiejska",
                            "14",
                            "25",
                            "Ustrzyki dolne",
                            "007",
                            "Jugoslawia"
                    );

                List<invoice> iv = List.of(mariusz);
                    for(invoice x: iv ){
                        boolean bla = repository.findByLastName(x.getLastName()).isPresent();
                        System.out.println(bla);
                        if(!bla){
                            repository.save(x);

                        }
                    }

                };

        }

}
