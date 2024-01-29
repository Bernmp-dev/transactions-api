package br.com.bootcamp.services;

import br.com.bootcamp.models.dtos.ResponseDto;
import br.com.bootcamp.models.entities.TransactionEntity;
import br.com.bootcamp.models.repositories.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
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

    public Optional<TransactionEntity> getTransactionById(Long id) {
        return  transactionRepo.findById(id);
    }

    public TransactionEntity insertTransaction(TransactionEntity transaction) {
        return transactionRepo.save(transaction);
    }

    public List<TransactionEntity> insertTransactionsBatch(
            List<TransactionEntity> transactionsBatch
    ) {
        return transactionRepo.saveAll(transactionsBatch);
    }

    public ResponseDto<TransactionEntity> updateTransactionById(
            Long id,
            TransactionEntity transaction
    ) {
        boolean transactionExists = transactionRepo.existsById(id);

        if (transactionExists) {
            transaction.setId(id);
            TransactionEntity updatedTransaction = transactionRepo.save(transaction);
            return new ResponseDto<>("Transaction updated successfully", updatedTransaction);
        }

        return new ResponseDto<>("Not Found", null);
    }

    public ResponseDto<TransactionEntity> deleteTransactionById(Long id) {
        Optional<TransactionEntity> transaction = transactionRepo.findById(id);

        if (transaction.isPresent()) {
            transactionRepo.delete(transaction.get());
            return new ResponseDto<>("Transaction deleted successfully ", transaction.get());

        }

        return new ResponseDto<>("Not Found", null);
    }

    public void deleteAllTransactions() {
        transactionRepo.deleteAll();
    }
}
