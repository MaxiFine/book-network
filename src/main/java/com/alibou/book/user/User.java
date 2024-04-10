package com.alibou.book.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "_user")
@EntityListeners(AuditingEntityListener.class)
public class User implements UserDetails {

        @Id
        @GeneratedValue
        private Integer id;

        private String firstname;
        private String lastname;
        private LocalDate dateOfBirth;
        @Column(unique = true)
        private String email;
        private String password;
        private boolean accountLocked;
        private boolean enabled;

        // we want to know when the user registered
        @CreatedDate
        @Column(nullable = false, updatable = false)
        private LocalDateTime createdDate;
        @LastModifiedDate
        @Column(insertable = false)
        private LocalDateTime lastModifiedDate;

        // private list of Role for our users



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {  // username will be email in our case
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !accountLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    private String fullName(){
        return firstname + " " +  lastname;
    }
}
