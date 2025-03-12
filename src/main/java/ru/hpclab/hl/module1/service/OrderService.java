package ru.hpclab.hl.module1.service;

import org.springframework.stereotype.Service;
import ru.hpclab.hl.module1.api.repository.IOrderRepository;
import ru.hpclab.hl.module1.api.repository.IRestFullService;
import ru.hpclab.hl.module1.model.order.Order;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService implements IRestFullService<Order> {
    private final IOrderRepository orderRepository;

    public OrderService(IOrderRepository orderRepository) {
            this.orderRepository = orderRepository;
        }

    @Override
    public Order create(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order getById(UUID id) {
        return orderRepository.findById(id);
    }

    @Override
    public void delete(UUID id) {
        orderRepository.delete(id);
    }

    public BigDecimal calculateTotalPrice(UUID orderId) {
        Order order = getById(orderId);
        return order.getOrderItems().stream()
                .map(item -> item.getProduct().getPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
