package com.alibou.book.common;


import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class PageResponse<T> {
    private List<T> content;
    private int number;
    private int size;
    private long totalElements;
    private  int totalPages;
    private boolean first;
    private boolean last;

}
