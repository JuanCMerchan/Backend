package com.desarrolloweb.proyecto.jpa.services;

import java.util.List;

import com.desarrolloweb.proyecto.jpa.model.User;

public interface IUserService{
    public boolean addUser(User user);

    public boolean updateUser(User user);

    public boolean deleteUser(User user);

    public boolean deleteUser(String username);

    public User getUser(Long id);

    public User getUser(String name);

    public User getUserByUsername(String email);

    public List<User> getAllUsers();
}
