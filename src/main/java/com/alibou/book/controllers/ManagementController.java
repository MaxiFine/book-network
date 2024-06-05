package com.alibou.book.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/manager")
public class ManagementController {

    @GetMapping
    public String get(){
        return "POST:: manager Controller get";
    }
    @PostMapping
    public String post(){
        return "POST:: manager Controller post";
    }
    @PutMapping
    public String put(){
        return "POST:: manager Controller put";
    }
    @DeleteMapping
    public String delete(){
        return "POST:: manager Controller delete";
    }
}
