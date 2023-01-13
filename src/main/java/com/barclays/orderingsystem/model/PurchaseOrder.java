package com.barclays.orderingsystem.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class PurchaseOrder {

    @Id
    @GeneratedValue
    private int purchaseOrderNumber;

    private double taxRate = .075;

    @ManyToOne
    @JoinColumn(name = "salesperson_id")
    private Salesperson salesperson;

    @OneToMany(mappedBy = "myOrder", cascade = CascadeType.ALL)
    private List<LineItem> myItems = new ArrayList<>();

    public Salesperson getSalesperson() {
        return salesperson;
    }

    public void setSalesperson(Salesperson salesperson) {
        this.salesperson = salesperson;
    }

    public int getPurchaseOrderNumber() {
        return purchaseOrderNumber;
    }

    public void setPurchaseOrderNumber(int purchaeOrderNumber) {
        this.purchaseOrderNumber = purchaeOrderNumber;
    }

    public List<LineItem> getMyItems() {
        return myItems;
    }

    public void setMyItems(List<LineItem> myItems) {
        this.myItems = myItems;
    }

    public double getTotalPrice() {
        double total = 0;

        for (LineItem l : myItems) {
            total += l.getLineItemTotal();
        }
        return total*(1+taxRate);
    }

    public void addLineItem(LineItem li) {
        myItems.add(li);
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }
}
