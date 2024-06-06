package com.alibou.book.book;


import com.alibou.book.book.BookService.*;
import com.alibou.book.common.PageResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Parameter;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    // all returned books
    @GetMapping("/returned")
    public ResponseEntity<PageResponse<BorrowedBookResponse>> findAllReturnedBooksController(
            @RequestParam(name = "page", defaultValue = "0", required = false) int page,
            @RequestParam(name = "size", defaultValue = "15", required = false) int size,
            Authentication connectedUser){
        return ResponseEntity.ok(bookService.findAllReturnedBooks(page, size, connectedUser));
    }

    @PatchMapping("/shareable/{book-id}")
    public ResponseEntity<Integer> updateShareableStatus(
            @PathVariable("book-id") Integer bookId,
            Authentication connectedUser){
        return ResponseEntity.ok(bookService.updateShareableStatus(bookId, connectedUser));
    }

    // update archive status
    @PatchMapping("/shareable/{book-id}")
    public ResponseEntity<Integer> updateArchiveStatus(
            @PathVariable("book-id") Integer bookId,
            Authentication connectedUser){
        return ResponseEntity.ok(bookService.updateArchivedStatus(bookId, connectedUser));
    }

    // Borrowing a book feature
    @PostMapping("/borrow/{bookId}")
    public ResponseEntity<Integer> borrowBookController(
            @PathVariable("bookId") Integer bookId,
            Authentication connectedUser){
        return ResponseEntity.ok(bookService.borrowBook(bookId, connectedUser));
    }

    // returning a book service
    @PatchMapping("/borrow/return/{bookId}")
    public ResponseEntity<Integer> returnBorrowedBook(@PathVariable("bookId") Integer bookId,
                                                      Authentication connectedUser){
        return ResponseEntity.ok(bookService.returnBorrowedBook(bookId, connectedUser));
    }

    @PatchMapping("/borrow/return/approve/{bookId}")
    public ResponseEntity<Integer> approveReturnedBorrowBook(
            @PathVariable("bookId") Integer bookId,
            Authentication connectedUser){
        return ResponseEntity.ok(bookService.approveReturnBorrowedBook(bookId, connectedUser));
    }

    // uploading a file to our file system
    @PostMapping(value = "/cover/{bookId}", consumes = "miultipart/form-data")
    public ResponseEntity<?> uploadBookCoverPicture(
            @PathVariable("bookId") Integer bookId,
            @RequestPart("file")MultipartFile file,
            Authentication connectedUser){
        bookService.uploadBookCoverPicture(file, connectedUser, bookId);
        return ResponseEntity.accepted().build();
    }


}
