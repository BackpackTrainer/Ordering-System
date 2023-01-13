package com.barclays.orderingsystem.repositories;

import com.barclays.orderingsystem.model.Salesperson;

public interface SalesPersonRepository {
    Salesperson save(Salesperson salesperson);

    Salesperson updateSalesperson(Salesperson salesperson);

    Salesperson findSalespersonByName(String name);
}
