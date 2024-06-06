package com.alibou.book.controllers;


import com.alibou.book.common.PageResponse;
import com.alibou.book.feedback.FeedbackRequest;
import com.alibou.book.feedback.FeedbackResponse;
import com.alibou.book.feedback.FeedbackService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/feedbacks")
@RequiredArgsConstructor
@Tag("Feedback")
public class FeedbackController {

    private final FeedbackService feedbackService;

    @PostMapping
    public ResponseEntity<Integer> saveFeedback(@Valid @RequestBody FeedbackRequest request, Authentication connectedUser){
        return ResponseEntity.ok(feedbackService.save(request, connectedUser));
    }

    @GetMapping("/book/{bookId}")
    public ResponseEntity<PageResponse<FeedbackResponse>> findAllFeedbackByBook(
            @PathVariable("bookId") Integer bookId,
            @RequestParam(name = "page", defaultValue = "0", required = false) int page,
            @RequestParam(name = "size", defaultValue = "20", required = false) int size,
            Authentication connectedUser){
        return ResponseEntity.ok(feedbackService.findAllFeedbackByBook(bookId, page, size, connectedUser));
    }

//    @GetMapping("/book/{bookId}")
//    public ResponseEntity<PageResponse<FeedbackResponse>> findAllFeedbackByBook(
//          @PathVariable("bookId") Integer bookId,
//          @RequestParam(name = "page", defaultValue = "0", required = false) int page,
//          @RequestParam(name = "size", defaultValue = "15", required = false) int size,
//          Authentication connectedUser){}
}
