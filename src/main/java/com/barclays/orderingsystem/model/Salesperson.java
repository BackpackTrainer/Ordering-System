package com.barclays.orderingsystem.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity public class Salesperson {
    @Id
    @GeneratedValue
    private long id;

    private String name;
    private String email;
    private String phone;

    @OneToMany(mappedBy = "salesperson", cascade = CascadeType.ALL)
    List<PurchaseOrder> mySales = new ArrayList<>();

    public void addPurchaseOrder(PurchaseOrder po) {
        mySales.add(po);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<PurchaseOrder> getMySales() {
        return mySales;
    }

    public void setMySales(List<PurchaseOrder> mySales) {
        this.mySales = mySales;
    }

    public double getTotalSales() {
        double totalSales = 0.0;
        for(PurchaseOrder p: mySales) {
            totalSales += p.getTotalPrice();
        }
        return totalSales;
    }
}
