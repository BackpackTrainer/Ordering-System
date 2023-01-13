package com.barclays.orderingsystem.repositories;

import com.barclays.orderingsystem.model.Product;

public interface ProductRepository {
    Product save(Product p);

    Product updateProduct(Product p);

    Product getProductByName(String name);
}
