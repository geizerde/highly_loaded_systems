package ru.hpclab.hl.module1.api.repository;

import org.springframework.stereotype.Repository;
import ru.hpclab.hl.module1.model.Order;

import java.util.List;
import java.util.UUID;

@Repository
public interface IOrderRepository {
    List<Order> findAll();
    Order findById(UUID id);
    void delete(UUID id);
    Order save(Order entity);
    Order update(Order entity);
    void clear();
}