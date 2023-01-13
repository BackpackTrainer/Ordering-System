package com.barclays.orderingsystem.service;

import com.barclays.orderingsystem.model.PurchaseOrder;
import com.barclays.orderingsystem.model.Salesperson;
import jakarta.transaction.Transactional;

public interface PurchaseOrderService {
    PurchaseOrder createPurchaseOrder(String name);

    void addLineItem(String productName, int quantity);

    @Transactional
    double processPO();
}
