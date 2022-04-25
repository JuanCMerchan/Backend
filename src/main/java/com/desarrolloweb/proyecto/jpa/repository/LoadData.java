package com.desarrolloweb.proyecto.jpa.repository;

import java.util.ArrayList;

import com.desarrolloweb.proyecto.jpa.model.Purchase;
import com.desarrolloweb.proyecto.jpa.model.User;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadData 
{
    @Bean  
    CommandLineRunner populatorDB (UserRepository userRepository, ProductRepository productRepository, PurchaseRepository purchaseRepository, InvoiceRepository invoiceRepository)
    {
        return args ->{
            System.out.println("Poblando la BD\n");
            User user = new User();
            user.setEmail("juancamerchan@gmail.com");
            user.setIsAdmin(true);
            user.setName("Juan");
            user.setPassword("lapassmaschevere");
            user.setShoppingCart(new ArrayList<Purchase>());

            userRepository.save(user);
            
        };
    } 
}
