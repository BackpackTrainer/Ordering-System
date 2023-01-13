package com.barclays.orderingsystem.service;

import com.barclays.orderingsystem.model.PurchaseOrder;
import com.barclays.orderingsystem.model.Salesperson;
import com.barclays.orderingsystem.repositories.SalesPersonRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SalespersonServiceImp implements SalespersonService {

    @Autowired
    SalesPersonRepository salesPersonRepository;

    @Override
    @Transactional
    public Salesperson save(Salesperson s) {
        salesPersonRepository.save(s);
        return s;
    }

    @Override
    @Transactional
    public Salesperson updateSalesperson(Salesperson salesperson) {
        salesPersonRepository.updateSalesperson(salesperson);
        return salesperson;
    }

    @Override
    @Transactional
    public double getTotalSales(String name) {
        Salesperson salesperson = salesPersonRepository.findSalespersonByName(name);
        List<PurchaseOrder> mySales = salesperson.getMySales();
        double totalSales = 0.0;
        for(PurchaseOrder p: mySales) {
            totalSales += p.getTotalPrice();
        }
        return totalSales;
    }

    @Override
    public Salesperson findSalespersonByName(String name) {
        return salesPersonRepository.findSalespersonByName(name);
    }
}
