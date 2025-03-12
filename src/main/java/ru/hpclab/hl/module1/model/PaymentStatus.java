package ru.hpclab.hl.module1.model;

import lombok.*;

@Getter
@AllArgsConstructor
public enum PaymentStatus {
    PENDING("Pending"),
    PAID("Paid"),
    FAILED("Failed");

    private final String status;
}
