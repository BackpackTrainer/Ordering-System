package com.barclays.orderingsystem;

import com.barclays.orderingsystem.model.Product;
import com.barclays.orderingsystem.model.Salesperson;
import com.barclays.orderingsystem.service.ProductService;
import com.barclays.orderingsystem.service.SalespersonService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Populator implements CommandLineRunner {

    ProductService productService;

    SalespersonService salespersonService;

    public Populator(ProductService productService, SalespersonService salespersonService) {
        this.productService = productService;
        this.salespersonService = salespersonService;
    }

    @Override
    public void run(String... args) throws Exception {
        Product p1 = new Product();
        p1.setUnitPrice(3.0);
        p1.setName("mug");
        p1.setQuantityOnHand(20);
        productService.save(p1);

        Product p2 = new Product();
        p2.setUnitPrice(5.0);
        p2.setName("notebook");
        p2.setQuantityOnHand(50);
        productService.save(p2);

        Product p3 = new Product();
        p3.setUnitPrice(6.0);
        p3.setName("scarf");
        p3.setQuantityOnHand(1);
        productService.save(p3);

        Salesperson salesperson = new Salesperson();
        salesperson.setName("Kamila");
        salespersonService.save(salesperson);

    }
}
