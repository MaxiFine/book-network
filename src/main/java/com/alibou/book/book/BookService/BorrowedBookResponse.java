package com.alibou.book.book.BookService;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class BorrowedBookResponse {

    private Integer id;
    private String title;
    private String authorName;
    private String isbn;
    private double rate;   // rating from users
    private boolean returned;
    private boolean returnApproved;
}
