package com.desarrolloweb.proyecto.jpa.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import com.desarrolloweb.proyecto.jpa.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findById(Long Id);

    Optional<User> findByName(String name);

    Optional<User> findByEmail(String email);
}
