package com.desarrolloweb.proyecto.jpa.services;

import com.desarrolloweb.proyecto.jpa.model.Role;
import com.desarrolloweb.proyecto.jpa.repository.RoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService implements IRoleService{
    @Autowired
    RoleRepository roleRepository;

    @Override
    public Role getRoleByName(String name)
    {
        return roleRepository.findByName(name).get();
    }
}
