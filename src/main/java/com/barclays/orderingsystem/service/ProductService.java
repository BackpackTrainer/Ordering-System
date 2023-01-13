package com.barclays.orderingsystem.service;

import com.barclays.orderingsystem.model.Product;
import jakarta.transaction.Transactional;

public interface ProductService {
    @Transactional
    Product save(Product p);

    Product getProductByName(String name);
}
