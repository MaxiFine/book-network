package com.alibou.book.auth;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AuthenticationRequest {
    @NotEmpty(message = "Email is mandatory")
    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email is not formatted. --> ali@mail.com")
    private String email;
    @NotEmpty(message = "You must set Password")
    @NotBlank(message = "You must set Password")
    @Size(min = 8,  message = "Password should be 8 characters long minimum")
    private String password;
}
