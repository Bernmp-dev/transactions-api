package br.com.bootcamp.models.entities;

import jakarta.persistence.*;
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
    private String category;
    private Double value;
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
