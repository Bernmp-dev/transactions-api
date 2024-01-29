package br.com.bootcamp.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "transaction")
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Category não pode ser nulo ou vazio!")
    private String category;

    @NotNull(message = "Value não pode estar vazio!")
    private Double value;

    @NotNull(message = "Data não pode ser nula!")
    @PastOrPresent(message = "Data não pode ser no futuro!")
    private LocalDate date;

    public TransactionEntity() {

    }

    public TransactionEntity(
            String category,
            Double value,
            LocalDate date
    ) {
        this.category = category;
        this.value = value;
        this.date = date;
    }

}
