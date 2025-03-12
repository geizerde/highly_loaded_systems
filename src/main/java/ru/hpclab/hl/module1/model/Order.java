package ru.hpclab.hl.module1.model;

import lombok.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {
    private UUID id;
    private List<OrderItem> orderItems;
    private Customer customer;
    private LocalDateTime orderDate;
    private PaymentStatus paymentStatus;
}