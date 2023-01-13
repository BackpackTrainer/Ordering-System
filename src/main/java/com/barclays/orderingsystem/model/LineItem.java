package com.barclays.orderingsystem.model;

import jakarta.persistence.*;


@Entity
public class LineItem {

    @Id
    @GeneratedValue
    Long lineItemID;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "myProduct")
    private Product myProduct;

    @ManyToOne
    @JoinColumn(name = "myItems")
    private PurchaseOrder myOrder;

    public Long getLineItemID() {
        return lineItemID;
    }

    public void setLineItemID(Long lineItemID) {
        this.lineItemID = lineItemID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public PurchaseOrder getMyOrder() {
        return myOrder;
    }

    public void setMyOrder(PurchaseOrder myOrder) {
        this.myOrder = myOrder;
    }

    public Product getMyProduct() {
        return myProduct;
    }

    public void setMyProduct(Product myProduct) {
        this.myProduct = myProduct;
    }

    public double getLineItemTotal()  {
        return (quantity* myProduct.getUnitPrice());
    }


}