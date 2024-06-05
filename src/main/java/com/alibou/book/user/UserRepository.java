package com.alibou.book.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    // this method will enable us to find our users by their
    // email which is unique
    Optional<User> findByEmail(String email);
}
