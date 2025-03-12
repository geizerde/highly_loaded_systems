package ru.hpclab.hl.module1.model.order;

import lombok.*;
import ru.hpclab.hl.module1.model.Product;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItem {
    private Product product;
    private int quantity;
}