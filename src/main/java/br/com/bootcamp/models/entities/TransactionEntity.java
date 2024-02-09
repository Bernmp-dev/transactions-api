package br.com.bootcamp.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "\"transaction\"")
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Category cannot be null or empty!")
    private String category;

    @NotNull(message = "Value cannot be empty!")
    private Double value;

    @NotNull(message = "Date cannot be null!")
    @PastOrPresent(message = "Date cannot be in the future!")
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
