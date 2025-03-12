package ru.hpclab.hl.module1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.hpclab.hl.module1.model.order.Order;
import ru.hpclab.hl.module1.service.OrderService;

import java.math.BigDecimal;

@RestController
@RequestMapping("/orders")
public class OrderController extends AbstractRestController<Order> {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        super(orderService);
        this.orderService = orderService;
    }

    @GetMapping("/{id}/total-price")
    public BigDecimal calculateTotalPrice(@PathVariable Long id) {
        return orderService.calculateTotalPrice(id);
    }
}
