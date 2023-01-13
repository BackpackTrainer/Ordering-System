package com.barclays.orderingsystem.repositories;

import com.barclays.orderingsystem.model.PurchaseOrder;

public interface PurchaseOrderRepository {
    PurchaseOrder save(PurchaseOrder po);

    PurchaseOrder updatePurchaseOrder(PurchaseOrder po);

    PurchaseOrder findPurchaseOrderById(int id);
}
