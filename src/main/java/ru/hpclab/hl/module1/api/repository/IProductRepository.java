package ru.hpclab.hl.module1.api.repository;

import org.springframework.stereotype.Repository;
import ru.hpclab.hl.module1.model.Product;

import java.util.List;
import java.util.UUID;

@Repository
public interface IProductRepository {
    List<Product> findAll();
    Product findById(UUID id);
    void delete(UUID id);
    Product save(Product entity);
    Product update(Product entity);
    void clear();
}