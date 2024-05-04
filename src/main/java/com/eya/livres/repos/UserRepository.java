package com.eya.livres.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eya.livres.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
User findByUsername (String username);
}


