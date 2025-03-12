package ru.hpclab.hl.module1.service;

import org.springframework.stereotype.Service;
import ru.hpclab.hl.module1.api.repository.IOrderRepository;
import ru.hpclab.hl.module1.model.order.Order;

import java.math.BigDecimal;

@Service
public class OrderService extends AbstractRestFullService<Order> {
    public OrderService(IOrderRepository orderRepository) {
        super(orderRepository);
    }

    public BigDecimal calculateTotalPrice(Long orderId) {
        Order order = getById(orderId);
        return order.getOrderItems().stream()
                .map(item -> item.getProduct().getPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}