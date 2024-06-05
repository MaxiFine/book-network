package com.alibou.book.history;

import com.alibou.book.book.BaseEntity;
import com.alibou.book.book.Book;
import com.alibou.book.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder  // to build from parent class
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BookTransactionHistory extends BaseEntity {
    // association table btn user and book

    // user relationship to the books
    // book relationship to the various entities
    private boolean returned;
    private boolean returnedApproved;

    // mapping btn user and book association
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;  // a user can have many transaction of book history
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
}
