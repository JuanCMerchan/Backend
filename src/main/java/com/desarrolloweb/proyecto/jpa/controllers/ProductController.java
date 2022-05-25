package com.desarrolloweb.proyecto.jpa.controllers;

import java.util.ArrayList;
import java.util.List;

import com.desarrolloweb.proyecto.jpa.DTOs.ProductDTO;
import com.desarrolloweb.proyecto.jpa.model.Product;
import com.desarrolloweb.proyecto.jpa.services.IProductService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.solr.core.query.SolrPageRequest;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("/{id}")
    public ProductDTO getProduct(@PathVariable("id") long id)
    {
        return convertDTO(productService.getProduct(id));
    }

    @GetMapping("/")
    public List<ProductDTO> getProducts()
    {
        List<Product> products = productService.getAllProducts();
        List<ProductDTO> result = convertDTOs(products);
        return result;
    }

    @GetMapping("/page/{page}/{size}")
    public List<ProductDTO> getProducts(@PathVariable("page") int page, @PathVariable("size") int size)
    {
        Pageable pageable = new SolrPageRequest(page, size, Sort.by(Direction.ASC, "id"));
        Page<Product> products = productService.getProductPage(pageable);
        List<ProductDTO> result = convertDTOs(products);
        return result;
    }


    @GetMapping("/page/{page}/{size}/{partialName}")
    public List<ProductDTO> getProducts(@PathVariable("page") int page, @PathVariable("size") int size, @PathVariable("partialName") String partialName)
    {
        Pageable pageable = new SolrPageRequest(page, size, Sort.by(Direction.ASC, "id"));
        Page<Product> products = productService.getProductPage(partialName, pageable);
        List<ProductDTO> result = convertDTOs(products);
        return result;
    }

    @PostMapping("/create")
    public boolean createProduct(@RequestBody Product newProduct)
    {
        return productService.addProduct(newProduct);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteProduct(@PathVariable("id") long id)
    {
        return productService.deleteProduct(id);
    }

    @PutMapping("/update")
    public boolean updateProduct(@RequestBody Product Product)
    {
        return productService.updateProduct(Product);
    }

    private ProductDTO convertDTO(Product product)
    {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(product, ProductDTO.class);
    }

    private List<ProductDTO> convertDTOs(Page<Product> products)
    {
        List<ProductDTO> result = new ArrayList<>();
        for(Product product : products)
        {
            result.add(convertDTO(product));
        }
        return result;
    }   

    private List<ProductDTO> convertDTOs(List<Product> products)
    {
        List<ProductDTO> result = new ArrayList<>();
        for(Product product : products)
        {
            result.add(convertDTO(product));
        }
        return result;
    }   
}
