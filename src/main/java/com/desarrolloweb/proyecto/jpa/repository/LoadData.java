package com.desarrolloweb.proyecto.jpa.repository;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import com.desarrolloweb.proyecto.jpa.model.Invoice;
import com.desarrolloweb.proyecto.jpa.model.Product;
import com.desarrolloweb.proyecto.jpa.model.Purchase;
import com.desarrolloweb.proyecto.jpa.model.User;
import com.ibm.icu.text.SimpleDateFormat;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadData {
    @Bean
    CommandLineRunner populatorDB(UserRepository userRepository, ProductRepository productRepository,
            PurchaseRepository purchaseRepository, InvoiceRepository invoiceRepository) {
        return args -> {

            System.out.println("Poblando la BD\n");

            // usuarios
            User user = new User();
            user.setEmail("juancamerchan@gmail.com");
            user.setIsAdmin(true);
            user.setName("Juan pablo");
            user.setPassword("lapassmaschevere");
            user.setShoppingCart(new ArrayList<Purchase>());
            userRepository.save(user);

            User user2 = new User();
            user2.setEmail("carlistos@gmail.com");
            user2.setIsAdmin(false);
            user2.setName("Carlos");
            userRepository.save(user2);

            User user3 = new User();
            user3.setEmail("lolaamantehelados@hotmail.com");
            user3.setIsAdmin(false);
            user3.setName("Isabella villa");
            userRepository.save(user3);

            User user4 = new User();
            user4.setEmail("meencantaelhelado@yahoo.com");
            user4.setIsAdmin(false);
            user4.setName("Juan Carlos");
            userRepository.save(user4);

            User user5 = new User();
            user5.setEmail("vera.pablo@gmail.com");
            user5.setIsAdmin(false);
            user5.setName("Pablo vera");
            userRepository.save(user5);

            // Productos
            Product product = new Product();
            product.setName("Helado de mandarina");
            product.setPrice(29900);
            BufferedImage bImage = ImageIO.read(new File("images/products/prod1.jpg"));
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ImageIO.write(bImage, "jpg", bos);
            byte[] data = bos.toByteArray();
            product.setImage(data);
            productRepository.save(product);

            Product product2 = new Product();
            product2.setName("Helado de fresa");
            product2.setPrice(29900);
            BufferedImage bImage2 = ImageIO.read(new File("images/products/prod2.jpg"));
            ByteArrayOutputStream bos2 = new ByteArrayOutputStream();
            ImageIO.write(bImage2, "jpg", bos2);
            byte[] data2 = bos2.toByteArray();
            product2.setImage(data2);
            productRepository.save(product2);

            Product product3 = new Product();
            product3.setName("Helado de chocolate");
            product3.setPrice(29900);
            BufferedImage bImage3 = ImageIO.read(new File("images/products/prod3.jpg"));
            ByteArrayOutputStream bos3 = new ByteArrayOutputStream();
            ImageIO.write(bImage3, "jpg", bos3);
            byte[] data3 = bos3.toByteArray();
            product3.setImage(data3);
            productRepository.save(product3);

            Product product4 = new Product();
            product4.setName("Helado de crema de Limón");
            product4.setPrice(29900);
            BufferedImage bImage4 = ImageIO.read(new File("images/products/prod4.jpg"));
            ByteArrayOutputStream bos4 = new ByteArrayOutputStream();
            ImageIO.write(bImage4, "jpg", bos4);
            byte[] data4 = bos4.toByteArray();
            product4.setImage(data4);
            productRepository.save(product4);

            Product product5 = new Product();
            product5.setName("Helado de frutos del bosque");
            product5.setPrice(29900);
            BufferedImage bImage5 = ImageIO.read(new File("images/products/prod5.jpg"));
            ByteArrayOutputStream bos5 = new ByteArrayOutputStream();
            ImageIO.write(bImage5, "jpg", bos5);
            byte[] data5 = bos5.toByteArray();
            product5.setImage(data5);
            productRepository.save(product5);

            Product product6 = new Product();
            product6.setName("Helado de maracuya");
            product6.setPrice(29900);
            BufferedImage bImage6 = ImageIO.read(new File("images/products/prod6.jpg"));
            ByteArrayOutputStream bos6 = new ByteArrayOutputStream();
            ImageIO.write(bImage6, "jpg", bos6);
            byte[] data6 = bos6.toByteArray();
            product6.setImage(data6);
            productRepository.save(product6);

            Product product7 = new Product();
            product7.setName("Helado de Milky Way Gourmet");
            product7.setPrice(29900);
            BufferedImage bImage7 = ImageIO.read(new File("images/products/prod7.jpg"));
            ByteArrayOutputStream bos7 = new ByteArrayOutputStream();
            ImageIO.write(bImage7, "jpg", bos7);
            byte[] data7 = bos7.toByteArray();
            product7.setImage(data7);
            productRepository.save(product7);

            Product product8 = new Product();
            product8.setName("Helado de M&M`s Gourmet");
            product8.setPrice(29900);
            BufferedImage bImage8 = ImageIO.read(new File("images/products/prod8.jpg"));
            ByteArrayOutputStream bos8 = new ByteArrayOutputStream();
            ImageIO.write(bImage8, "jpg", bos8);
            byte[] data8 = bos8.toByteArray();
            product8.setImage(data8);
            productRepository.save(product8);

            Product product9 = new Product();
            product9.setName("Helado de Oreo Gourmet");
            product9.setPrice(29900);
            BufferedImage bImage9 = ImageIO.read(new File("images/products/prod9.jpg"));
            ByteArrayOutputStream bos9 = new ByteArrayOutputStream();
            ImageIO.write(bImage9, "jpg", bos9);
            byte[] data9 = bos9.toByteArray();
            product9.setImage(data9);
            productRepository.save(product9);

            Product product10 = new Product();
            product10.setName("Helado de Snickers Almond");
            product10.setPrice(29900);
            BufferedImage bImage10 = ImageIO.read(new File("images/products/prod10.jpg"));
            ByteArrayOutputStream bos10 = new ByteArrayOutputStream();
            ImageIO.write(bImage10, "jpg", bos10);
            byte[] data10 = bos10.toByteArray();
            product10.setImage(data10);
            productRepository.save(product10);

            Product product11 = new Product();
            product11.setName("Helado de Vainilla Chips Gourmet");
            product11.setPrice(29900);
            BufferedImage bImage11 = ImageIO.read(new File("images/products/prod11.jpg"));
            ByteArrayOutputStream bos11 = new ByteArrayOutputStream();
            ImageIO.write(bImage11, "jpg", bos11);
            byte[] data11 = bos11.toByteArray();
            product11.setImage(data11);
            productRepository.save(product11);

            Product product12 = new Product();
            product12.setName("Helado de Vainilla Gourmet");
            product12.setPrice(29900);
            BufferedImage bImage12 = ImageIO.read(new File("images/products/prod12.jpg"));
            ByteArrayOutputStream bos12 = new ByteArrayOutputStream();
            ImageIO.write(bImage12, "jpg", bos12);
            byte[] data12 = bos12.toByteArray();
            product12.setImage(data12);
            productRepository.save(product12);

            Product product13 = new Product();
            product13.setName("Helado de cereza italiana con yogurt");
            product13.setPrice(29900);
            BufferedImage bImage13 = ImageIO.read(new File("images/products/prod13.png"));
            ByteArrayOutputStream bos13 = new ByteArrayOutputStream();
            ImageIO.write(bImage13, "png", bos13);
            byte[] data13 = bos13.toByteArray();
            product13.setImage(data13);
            productRepository.save(product13);

            Product product14 = new Product();
            product14.setName("Helado de ron con pasas");
            product14.setPrice(29900);
            BufferedImage bImage14 = ImageIO.read(new File("images/products/prod14.jpg"));
            ByteArrayOutputStream bos14 = new ByteArrayOutputStream();
            ImageIO.write(bImage14, "jpg", bos14);
            byte[] data14 = bos14.toByteArray();
            product14.setImage(data14);
            productRepository.save(product14);

            Product product15 = new Product();
            product15.setName("Helado de cookies and cream");
            product15.setPrice(29900);
            BufferedImage bImage15 = ImageIO.read(new File("images/products/prod15.png"));
            ByteArrayOutputStream bos15 = new ByteArrayOutputStream();
            ImageIO.write(bImage15, "png", bos15);
            byte[] data15 = bos15.toByteArray();
            product15.setImage(data15);
            productRepository.save(product15);

            // purchases
            Purchase purchaseUser2 = new Purchase();
            purchaseUser2.setProduct(product);
            purchaseUser2.setQuantity(2);
            purchaseRepository.save(purchaseUser2);

            Purchase purchaseUser3 = new Purchase();
            purchaseUser3.setProduct(product2);
            purchaseUser3.setQuantity(3);
            purchaseRepository.save(purchaseUser3);

            Purchase purchaseUser4P3 = new Purchase();
            purchaseUser4P3.setProduct(product3);
            purchaseUser4P3.setQuantity(2);
            purchaseRepository.save(purchaseUser4P3);

            Purchase purchaseUser4P4 = new Purchase();
            purchaseUser4P4.setProduct(product4);
            purchaseUser4P4.setQuantity(1);
            purchaseRepository.save(purchaseUser4P4);

            Purchase purchaseUser4P5 = new Purchase();
            purchaseUser4P5.setProduct(product5);
            purchaseUser4P5.setQuantity(1);
            purchaseRepository.save(purchaseUser4P5);

            Purchase purchaseUser4P6 = new Purchase();
            purchaseUser4P6.setProduct(product6);
            purchaseUser4P6.setQuantity(1);
            purchaseRepository.save(purchaseUser4P6);

            Purchase purchaseUser4P7 = new Purchase();
            purchaseUser4P7.setProduct(product7);
            purchaseUser4P7.setQuantity(3);
            purchaseRepository.save(purchaseUser4P7);

            Purchase purchaseUser4P8 = new Purchase();
            purchaseUser4P8.setProduct(product8);
            purchaseUser4P8.setQuantity(1);
            purchaseRepository.save(purchaseUser4P8);

            // invoices
            Invoice invoiceUser2 = new Invoice();
            invoiceUser2.setUserId(user2.getId());
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date date = formatter.parse("22/04/2022");
            invoiceUser2.setDate(date);
            invoiceUser2.setPriceTotal(59800);
            List<Purchase> purchases = new ArrayList<Purchase>();
            purchases.add(purchaseUser2);
            invoiceUser2.setListPurchases(purchases);
            invoiceRepository.save(invoiceUser2);

            Invoice invoiceUser3 = new Invoice();
            invoiceUser3.setUserId(user3.getId());
            SimpleDateFormat formatter2 = new SimpleDateFormat("dd/MM/yyyy");
            Date date2 = formatter2.parse("22/04/2022");
            invoiceUser3.setDate(date2);
            invoiceUser3.setPriceTotal(89700);
            List<Purchase> purchases2 = new ArrayList<Purchase>();
            purchases2.add(purchaseUser3);
            invoiceUser3.setListPurchases(purchases2);

            invoiceRepository.save(invoiceUser3);

            Invoice invoiceUser4 = new Invoice();
            invoiceUser4.setUserId(user4.getId());
            SimpleDateFormat formatter3 = new SimpleDateFormat("dd/MM/yyyy");
            Date date3 = formatter3.parse("23/04/2022");
            invoiceUser4.setDate(date3);
            invoiceUser4.setPriceTotal(269100);
            List<Purchase> purchases3 = new ArrayList<Purchase>();
            purchases3.add(purchaseUser4P3);
            purchases3.add(purchaseUser4P4);
            purchases3.add(purchaseUser4P5);
            purchases3.add(purchaseUser4P6);
            purchases3.add(purchaseUser4P7);
            purchases3.add(purchaseUser4P8);
            invoiceUser4.setListPurchases(purchases3);
            invoiceRepository.save(invoiceUser4);

        };
    }
}
