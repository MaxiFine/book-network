package com.alibou.book.book;


import com.alibou.book.book.BookService.*;
import com.alibou.book.common.PageResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping
    public ResponseEntity<Integer> saveBook(
            @Valid @RequestBody BookRequest request,
            Authentication connectedUser) {  // give the connected user
    return ResponseEntity.ok(bookService.save(request, connectedUser));
    }

    @GetMapping("{book-id}")
    public ResponseEntity<BookResponse> findBookById(@PathVariable("book-id") Integer bookId){
        return ResponseEntity.ok(bookService.findById(bookId));
    }

    @GetMapping  // this method returns all the list of books in the system
    public ResponseEntity<PageResponse<BookResponse>> findAllBooks(
            @RequestParam(name = "page", defaultValue = "0", required = false) int page,
            @RequestParam(name = "size", defaultValue = "15", required = false) int size,
            Authentication connectedUser){
        return ResponseEntity.ok(bookService.findAllBooks(page, size, connectedUser));
    }

    // this method lists all the books by its owner
    @GetMapping("/owner")
    public ResponseEntity<PageResponse<BookResponse>> findAllForOwnerController(
            @RequestParam(name = "page", defaultValue = "0", required = false) int page,
            @RequestParam(name = "size", defaultValue = "15", required = false) int size,
            Authentication connectedUser){
        return ResponseEntity.ok(bookService.findAllBooksByOwner(page, size, connectedUser));
    }

    // find all borrowed books
    @GetMapping("/borrowed")
    public ResponseEntity<PageResponse<BorrowedBookResponse>> findAllBorrowedBooksController(
            @RequestParam(name = "page", defaultValue = "0", required = false) int page,
            @RequestParam(name = "size", defaultValue = "15", required = false) int size,
            Authentication connectedUser){
        return ResponseEntity.ok(bookService.findAllBorrowedBooks(page, size, connectedUser));
    }

}
