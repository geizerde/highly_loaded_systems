package ru.hpclab.hl.module1.model.order;

import lombok.*;
import ru.hpclab.hl.module1.api.model.Identifiable;
import ru.hpclab.hl.module1.model.Customer;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order implements Identifiable {
    private Long id;
    @Builder.Default
    private UUID identifier = UUID.randomUUID();
    private List<OrderItem> orderItems;
    private Customer customer;
    private LocalDateTime orderDate;
    private PaymentStatus paymentStatus;
}