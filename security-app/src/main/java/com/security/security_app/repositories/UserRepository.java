package com.security.security_app.repositories;

import com.security.security_app.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByUserName(String username);
    Optional<User> findByUserName(String username);
}
