package com.alibou.book.history;

import com.alibou.book.book.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookTransactionRepository extends JpaRepository<BookTransactionRepository, Integer> {
    // finds all the books borrowed by the user
    @Query("""  
            SELECT history
            FROM BookTransactionHistory  history
            WHERE history.user.id = :userId
            """)
    Page<BookTransactionHistory> findAllBorrowedBooks(Pageable pageable, Integer userId);

    // finds all books returned by the user
    @Query("""
            SELECT history
            FROM BookTransactionHistory  history
            WHERE history.book.owner.id = :userId
            """)
    Page<BookTransactionHistory> findAllReturnedBooks(Pageable pageable, Integer userId);
}
