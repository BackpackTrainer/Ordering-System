package com.barclays.orderingsystem.repositories;

import com.barclays.orderingsystem.model.PurchaseOrder;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class PurchaseOrderRepositoryImp implements PurchaseOrderRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public PurchaseOrder save(PurchaseOrder po) {
        entityManager.persist(po);
        return po;
    }

    @Override
    public PurchaseOrder updatePurchaseOrder(PurchaseOrder po) {
        entityManager.merge(po);
        return po;
    }

    @Override
    public PurchaseOrder findPurchaseOrderById(int id) {
        PurchaseOrder po = entityManager.createQuery("SELECT p FROM PurchaseOrder p where p.purchaseOrderNumber = :id", PurchaseOrder.class).
                setParameter("id", id).getSingleResult();
        return po;
    }

}
