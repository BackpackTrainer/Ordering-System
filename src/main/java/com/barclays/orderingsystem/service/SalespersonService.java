package com.barclays.orderingsystem.service;

import com.barclays.orderingsystem.model.Salesperson;
import jakarta.transaction.Transactional;

public interface SalespersonService {
    @Transactional
    Salesperson save(Salesperson s);

    @Transactional
    Salesperson updateSalesperson(Salesperson salesperson);

    double getTotalSales(String name);

    Salesperson findSalespersonByName(String name);
}
