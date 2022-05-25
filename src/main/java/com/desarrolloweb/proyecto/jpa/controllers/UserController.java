package com.desarrolloweb.proyecto.jpa.controllers;

import java.util.ArrayList;

import com.desarrolloweb.proyecto.jpa.DTOs.PurchaseDTO;
import com.desarrolloweb.proyecto.jpa.DTOs.UserDTO;
import com.desarrolloweb.proyecto.jpa.model.Purchase;
import com.desarrolloweb.proyecto.jpa.model.User;
import com.desarrolloweb.proyecto.jpa.services.IRoleService;
import com.desarrolloweb.proyecto.jpa.services.IUserService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    @Autowired
    private IRoleService roleService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/{username}")
    public UserDTO getuser(@PathVariable("username") String username)
    {
        User user = userService.getUserByUsername(username);
        UserDTO userDTO = convertDTO(user);
        if(user.getRole().getName().equals("ROLE_ADMIN"))
        {
            userDTO.setAdmin(true);
        }
        else
        {
            userDTO.setAdmin(false);
        }
        return userDTO;
    }

    @PostMapping("/create")
    public boolean createUser(@RequestBody User newUser)
    {
        newUser.setRole(roleService.getRoleByName("ROLE_USER"));
        newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
        return userService.addUser(newUser);
    }

    @DeleteMapping("/delete/{username}")
    public boolean deleteUser(@PathVariable("username") String username)
    {
        return userService.deleteUser(username);
    }

    @PutMapping("/update")
    public boolean updateUser(@RequestBody User user)
    {
        if(user.getPassword() != "")
        {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        }
        return userService.updateUser(user);
    }

    private UserDTO convertDTO(User user)
    {
        ModelMapper mapper = new ModelMapper();
        UserDTO result = mapper.map(user, UserDTO.class);
        result.setShoppingCart(new ArrayList<>());
        for(Purchase purchase : user.getShoppingCart())
        {
            PurchaseDTO purchaseDTO = mapper.map(purchase, PurchaseDTO.class);
            result.getShoppingCart().add(purchaseDTO);
        }
        return result;
    }
}
