package com.example.demo.cart;

import com.example.demo.book.book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface  cartRepository extends JpaRepository<cart,Long> {
    @Query("Select b.id, b.title, c.quantity, b.price, SUM(c.quantity * b.price) from book b  left join Cart c on b.id=c.cartID")
    public List<book> FindAllWithDescriptionQuery();

    Optional<cart> findByCartIDAndBooks_Id(Long cartID,Long bookID);
    Optional<cart> findByBooks_Id(Long bookId);
}
