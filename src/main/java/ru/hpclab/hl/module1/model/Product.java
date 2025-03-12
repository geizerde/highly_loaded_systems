package ru.hpclab.hl.module1.model;

import lombok.*;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    private UUID id;
    private String name;
    private String category;
    private BigDecimal price;
    private String manufacturer;
}
