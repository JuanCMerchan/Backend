package com.desarrolloweb.proyecto.jpa.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.desarrolloweb.proyecto.jpa.model.User;
import com.desarrolloweb.proyecto.jpa.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService, IUserService
{
    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override 
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        Optional<User> userOptional = userRepository.findByUsername(username);
        if(userOptional.isPresent())
        {
            User user = userOptional.get();
            var authorities = List.of(new SimpleGrantedAuthority(user.getRole().getName()));
            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
        }
        throw new UsernameNotFoundException(username);
    }

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
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username).get();
    }

    @Override
    public boolean updateUser(User user) {
        Optional<User> userOptional = userRepository.findById(user.getId());
        if(userOptional.isPresent())
        {
            User userTemp = userOptional.get();
            userTemp.setUsername(user.getUsername());
            userTemp.setRole(user.getRole());
            userTemp.setName(user.getName());
            userTemp.setPassword(user.getPassword());
            userTemp.setShoppingCart(user.getShoppingCart());
            userRepository.save(userTemp);
            return true;
        }
        return false;
    }  
}
