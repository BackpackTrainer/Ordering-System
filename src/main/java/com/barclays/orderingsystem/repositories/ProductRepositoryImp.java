package com.barclays.orderingsystem.repositories;

import com.barclays.orderingsystem.model.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepositoryImp implements ProductRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Product save(Product p) {
        entityManager.persist(p);
        return  p;
    }

    @Override
    public Product updateProduct(Product p) {
        entityManager.merge(p);
        return p;
    }

    @Override
    public Product getProductByName(String name) {
        String jpql = "SELECT p from Product p where p.name = :name";
        Product product = entityManager.createQuery(jpql, Product.class).
                setParameter("name", name).getSingleResult();
        return product;
    }
}
