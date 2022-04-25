package com.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> listAll() {
        return productRepository.findAll();
    }

    public Product save(Product product) {
        return productRepository.save(product);

    }

    public Product get(Integer id) {
        return productRepository.findById(id).get();
    }

    public void delete(Integer id) {
        productRepository.deleteById(id);
    }

    public Product update(Product product) {
        Product existProduct=null;
      Optional<Product> optional=  productRepository.findById(product.getId());
      if(optional.isPresent()){
          existProduct=optional.get();
          existProduct.setName(product.getName());
           existProduct.setPrice(product.getPrice());
           productRepository.save(existProduct);
      }
      return existProduct;
    }
}
