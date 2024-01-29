package br.com.bootcamp.models.dtos;

import br.com.bootcamp.models.entities.TransactionEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public record TransactionDto(
        Long id,
        @NotBlank(message = "Category não pode ser nulo ou vazio!")
        String category,
        @NotBlank(message = "Value não pode ser nulo!")
        @NotNull(message = "Value não pode estar vazio!")
        Double value,
        @NotNull(message = "Data não pode ser nula!")
        @PastOrPresent(message = "Data não pode ser no futuro!")
        LocalDate date
) {

    public TransactionEntity toEntity() {
        return new TransactionEntity(
                this.category,
                this.value,
                this.date
        );
    }
}
