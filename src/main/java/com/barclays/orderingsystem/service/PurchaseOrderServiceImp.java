package com.barclays.orderingsystem.service;

import com.barclays.orderingsystem.model.LineItem;
import com.barclays.orderingsystem.model.Product;
import com.barclays.orderingsystem.model.PurchaseOrder;
import com.barclays.orderingsystem.model.Salesperson;
import com.barclays.orderingsystem.repositories.ProductRepository;
import com.barclays.orderingsystem.repositories.PurchaseOrderRepository;
import com.barclays.orderingsystem.repositories.SalesPersonRepository;
import com.barclays.orderingsystem.repositories.SalesPersonRepositoryImp;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseOrderServiceImp implements PurchaseOrderService {

    private PurchaseOrder po;

    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SalesPersonRepository salesPersonRepository;

    @Autowired
    private SalespersonService salespersonService;

    @Override
    public PurchaseOrder createPurchaseOrder(String name) {
        po = new PurchaseOrder();
        Salesperson salesperson = salesPersonRepository.findSalespersonByName(name);
        po.setSalesperson(salesperson);
        return po;
    }



    @Override
    public void addLineItem(String productName, int quantity) {
        if(po == null) {
            po = new PurchaseOrder();
        }
        Product product = productRepository.getProductByName(productName);
        LineItem li = new LineItem();
        li.setQuantity(quantity);
        li.setMyProduct(product);
        li.setMyOrder(po);
        po.addLineItem(li);

    }

    @Override
    @Transactional
    public double processPO() {
        double totalPrice = po.getTotalPrice();
        purchaseOrderRepository.save(po);
        List<LineItem> lineItems = po.getMyItems();
        for(LineItem li: lineItems) {
            int quantitySold = li.getQuantity();
            Product product = li.getMyProduct();
            product.quantitySold(quantitySold);
            productRepository.updateProduct(product);
        }

//       Salesperson salesperson = po.getSalesperson();
//       salesperson.addPurchaseOrder(po);
//       salespersonService.updateSalesperson(salesperson);

       po = null;
       return totalPrice;
    }

}
