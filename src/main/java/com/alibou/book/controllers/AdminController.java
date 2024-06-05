package com.alibou.book.controllers;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin")
// adding the permission using annotations
@PreAuthorize("hasRole('ADMIN')")  // this way, it is set to permit only the admin to this controller
// on the class level
public class AdminController {

    @GetMapping
    // at the method level, we need to use the name of the permission that we have specified
    @PreAuthorize("hasAuthority('admin:read')")
    public String get(){
        return "POST:: admin Controller get";
    }
    @PostMapping
    @PreAuthorize("hasAuthority('admin:create')")
    public String post(){
        return "POST:: admin Controller post";
    }
    @PutMapping
    @PreAuthorize("hasAuthority('admin:update')")
    public String put(){
        return "POST:: admin Controller put";
    }
    @DeleteMapping
    @PreAuthorize("hasAuthority('admin:delete')")
    public String delete(){
        return "POST:: admin Controller delete";
    }

    // after setting the permissions on the method level you need to specify to spring
    // about it and specify it in the security configuration
}
