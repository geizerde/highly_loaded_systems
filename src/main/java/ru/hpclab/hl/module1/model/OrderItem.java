package ru.hpclab.hl.module1.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItem {
    private Product product;
    private int quantity;
}