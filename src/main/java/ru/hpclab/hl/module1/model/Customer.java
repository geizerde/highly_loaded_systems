package ru.hpclab.hl.module1.model;

import lombok.*;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {
    private UUID id;
    private String fullName;
    private String email;
    private String phone;
    private LocalDate registrationDate;
}
