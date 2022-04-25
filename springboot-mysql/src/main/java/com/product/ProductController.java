package com.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> listAll() {
        return productService.listAll();
    }

    @GetMapping("/products/{id}")
    public Product getById(@PathVariable Integer id) {
        return productService.get(id);
    }

    @PostMapping("/products")
    public Product add(@RequestBody Product product) {
        return productService.save(product);
    }
    @PutMapping("/products")
    public Product update(@RequestBody Product product) {
        return productService.update(product);
    }
    @DeleteMapping("/products/{id}")
    public void delete(@PathVariable Integer id) {
        productService.delete(id);
    }
}
