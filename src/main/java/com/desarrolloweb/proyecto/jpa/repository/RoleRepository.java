package com.desarrolloweb.proyecto.jpa.repository;
import java.util.Optional;

import com.desarrolloweb.proyecto.jpa.model.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends  JpaRepository<Role, Long>{
    Optional<Role> findById(Long Id);

    Optional<Role> findByName(String name);
}
