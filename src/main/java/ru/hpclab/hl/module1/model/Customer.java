package ru.hpclab.hl.module1.model;

import lombok.*;
import ru.hpclab.hl.module1.api.model.Identifiable;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer implements Identifiable {
    private Long id;
    @Builder.Default
    private UUID identifier = UUID.randomUUID();
    private String fullName;
    private String email;
    private String phone;
    private LocalDate registrationDate;
}
