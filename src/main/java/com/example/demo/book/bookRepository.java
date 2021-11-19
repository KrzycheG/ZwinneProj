package com.example.demo.book;
import javax.persistence.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface bookRepository
        extends JpaRepository<book,Long> {

     @Query("SELECT s FROM book s WHERE s.title =?1")
     Optional<book> findBookBytitle(String title);
      Optional<book> findById(Long id);



}
