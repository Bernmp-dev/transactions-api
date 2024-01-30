package br.com.bootcamp.models.repositories;

import br.com.bootcamp.models.entities.TransactionEntity;
import br.com.bootcamp.models.interfaces.CategorySumProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TransactionRepo extends JpaRepository<TransactionEntity, Long> {

    List<TransactionEntity> findAllByDate(LocalDate date);

    @Query("SELECT te.category AS category, SUM(te.value) AS totalValue FROM TransactionEntity te GROUP BY te.category")
    List<CategorySumProjection> sumValuesByCategory();

    @Query("SELECT te.category AS category, SUM(te.value) AS totalValue FROM TransactionEntity te WHERE te.category = :category GROUP BY te.category")
    CategorySumProjection sumValuesByCategory(String category);
}
