package com.alibou.book.book.BookService;


import com.alibou.book.book.Book;
import org.springframework.data.jpa.domain.Specification;

public class BookSpecification {

    public static Specification<Book> withOwnerId(Integer ownerId){
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(
                root.get("owner").get("id"), ownerId);
    }

}
