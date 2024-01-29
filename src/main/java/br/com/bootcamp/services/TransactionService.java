package br.com.bootcamp.services;

import br.com.bootcamp.models.entities.TransactionEntity;
import br.com.bootcamp.models.repositories.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepo transactionRepo;

    public List<TransactionEntity> getAllTransactions() {
        return transactionRepo.findAll();
    }

    public TransactionEntity insertTransaction(TransactionEntity transaction) {
        return transactionRepo.save(transaction);
    }

    public ResponseEntity<?> getTransactionById(Long id) {
        Optional<TransactionEntity> transaction = transactionRepo.findById(id);

        if (transaction.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found");
        }

        return ResponseEntity.status((HttpStatus.OK)).body(transaction);
    }
}
