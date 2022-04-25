package com.desarrolloweb.proyecto.jpa.services;

import java.util.List;
import java.util.Optional;

import com.desarrolloweb.proyecto.jpa.model.User;
import com.desarrolloweb.proyecto.jpa.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean addUser(User user) {
        userRepository.save(user);
        return true;
    }

    @Override
    public boolean deleteUser(User user) {
        Optional<User> userOptional = userRepository.findById(user.getId());
        if(userOptional.isPresent())
        {
            userRepository.delete(userOptional.get());
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteUser(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isPresent())
        {
            userRepository.delete(userOptional.get());
            return true;
        }
        return false;
    }

    @Override
    public List<User> getAllUsers() {
        
        return userRepository.findAll();
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User getUser(String name) {
        return userRepository.findByName(name).get();
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email).get();
    }

    @Override
    public boolean updateUser(User user) {
        Optional<User> userOptional = userRepository.findById(user.getId());
        if(userOptional.isPresent())
        {
            User userTemp = userOptional.get();
            userTemp.setEmail(user.getEmail());
            userTemp.setIsAdmin(user.getIsAdmin());
            userTemp.setName(user.getName());
            userTemp.setPassword(user.getPassword());
            userTemp.setShoppingCart(user.getShoppingCart());
            userRepository.save(userTemp);
            return true;
        }
        return false;
    }  
}
