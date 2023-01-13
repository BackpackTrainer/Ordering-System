package com.barclays.orderingsystem.service;

import com.barclays.orderingsystem.model.Product;
import com.barclays.orderingsystem.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    @Transactional
    public Product save(Product p) {
        productRepository.save(p);
        return p;
    }

    @Override
    public Product getProductByName(String name) {
        Product product = productRepository.getProductByName(name);
        return product;
    }
}
