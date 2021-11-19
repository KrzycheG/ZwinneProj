package com.example.demo.invoice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface invoiceRepository extends JpaRepository<invoice,Long> {


    Optional<invoice> findByLastName(String LastName);


}
