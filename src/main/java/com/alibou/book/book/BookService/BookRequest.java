package com.alibou.book.book.BookService;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record BookRequest(
        Integer id,
        @NotNull(message = "100")
        @NotNull(message = "100")
        String title,
        @NotNull(message = "101")
        @NotBlank(message = "101")
        String authorName,
        @NotNull(message = "102")
        @NotBlank(message = "102")
        String isbn,
        String synopsis,
        boolean shareable
) {
}
