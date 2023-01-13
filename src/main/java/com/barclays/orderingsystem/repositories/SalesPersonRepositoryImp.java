package com.barclays.orderingsystem.repositories;

import com.barclays.orderingsystem.model.Product;
import com.barclays.orderingsystem.model.Salesperson;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class SalesPersonRepositoryImp implements SalesPersonRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Salesperson save(Salesperson salesperson) {
        entityManager.persist(salesperson);
        return salesperson;
    }

    @Override
    public Salesperson updateSalesperson(Salesperson salesperson) {
        entityManager.merge(salesperson);
        return salesperson;
    }

    @Override
    public Salesperson findSalespersonByName(String name) {
        String jpql = "SELECT s from Salesperson s where s.name = :name";
        Salesperson salesperson = entityManager.createQuery(jpql, Salesperson.class).
                setParameter("name", name).getSingleResult();
        return salesperson;
    }
}
