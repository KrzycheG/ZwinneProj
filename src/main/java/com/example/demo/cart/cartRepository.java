package com.example.demo.cart;

import com.example.demo.book.book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface cartRepository extends JpaRepository<cart,Long> {
}
