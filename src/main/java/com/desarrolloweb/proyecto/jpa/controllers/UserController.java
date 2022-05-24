package com.desarrolloweb.proyecto.jpa.controllers;

import java.util.ArrayList;

import com.desarrolloweb.proyecto.jpa.DTOs.PurchaseDTO;
import com.desarrolloweb.proyecto.jpa.DTOs.UserDTO;
import com.desarrolloweb.proyecto.jpa.model.Purchase;
import com.desarrolloweb.proyecto.jpa.model.User;
import com.desarrolloweb.proyecto.jpa.services.IUserService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/{id}")
    public UserDTO getuser(@PathVariable("id") long id)
    {
        return convertDTO(userService.getUser(id));
    }

    @PostMapping("/create")
    public boolean createUser(@RequestBody User newUser)
    {
        return userService.addUser(newUser);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteUser(@PathVariable("id") long id)
    {
        return userService.deleteUser(id);
    }

    @PutMapping("/update")
    public boolean updateUser(@RequestBody User user)
    {
        return userService.updateUser(user);
    }

    private UserDTO convertDTO(User user)
    {
        ModelMapper mapper = new ModelMapper();
        UserDTO result = mapper.map(user, UserDTO.class);
        result.setShoppingCart(new ArrayList<>());
        for(Purchase purchase : user.getShoppingCart())
        {
            result.getShoppingCart().add(mapper.map(purchase, PurchaseDTO.class));
        }
        return result;
    }
}
