package ru.hpclab.hl.module1.controller;

import org.springframework.web.bind.annotation.*;
import ru.hpclab.hl.module1.model.order.Order;
import ru.hpclab.hl.module1.service.OrderService;

import java.math.BigDecimal;
import java.util.*;

@RestController
@RequestMapping("/orders")
public class OrderController extends AbstractRestController<Order> {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        super(orderService);
        this.orderService = orderService;
    }

    @GetMapping("/{id}/total-price")
    public BigDecimal calculateTotalPrice(@PathVariable UUID id) {
        return orderService.calculateTotalPrice(id);
    }
}
