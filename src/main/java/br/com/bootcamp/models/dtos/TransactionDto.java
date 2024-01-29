package br.com.bootcamp.models.dtos;

import br.com.bootcamp.models.entities.TransactionEntity;

import java.time.LocalDate;

public record TransactionDto(
        Long id,
        String category,
        Double value,
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
