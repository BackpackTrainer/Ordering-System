package com.barclays.orderingsystem;

import com.barclays.orderingsystem.model.LineItem;
import com.barclays.orderingsystem.model.Product;
import com.barclays.orderingsystem.model.PurchaseOrder;
import com.barclays.orderingsystem.model.Salesperson;
import com.barclays.orderingsystem.repositories.SalesPersonRepository;
import com.barclays.orderingsystem.service.ProductService;
import com.barclays.orderingsystem.service.PurchaseOrderService;
import com.barclays.orderingsystem.service.SalespersonService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class OrderingSystemApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(OrderingSystemApplication.class, args);
        ProductService productService = context.getBean(ProductService.class);
        PurchaseOrderService purchaseOrderService = context.getBean(PurchaseOrderService.class);
        SalespersonService salespersonService = context.getBean(SalespersonService.class);

        purchaseOrderService.createPurchaseOrder("Kamila");
        purchaseOrderService.addLineItem("mug", 2);
        purchaseOrderService.addLineItem("notebook", 1);

        System.out.println("The total price is " + purchaseOrderService.processPO());
        Salesperson salesperson = salespersonService.findSalespersonByName("Kamila");
        System.out.println(salesperson.getName() + "'s total sales were " + salespersonService.getTotalSales("Kamila"));

    }

}
