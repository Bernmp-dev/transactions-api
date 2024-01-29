package br.com.bootcamp.controllers;

import br.com.bootcamp.models.dtos.ResponseDto;
import br.com.bootcamp.models.entities.TransactionEntity;
import br.com.bootcamp.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TransactionEntity> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTransactionById(@PathVariable Long id) {
        Optional<TransactionEntity> transaction = transactionService.getTransactionById(id);

        if (transaction.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found");
        }

        return ResponseEntity.status((HttpStatus.OK)).body(transaction.get());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TransactionEntity insertTransaction(
            @RequestBody TransactionEntity transaction
    ) {
        return transactionService.insertTransaction(transaction);
    }

    @PostMapping("/batch")
    public ResponseEntity<List<TransactionEntity>> insertTransactionsBatch(
            @RequestBody List<TransactionEntity> transactionsBatch
    ) {
        List<TransactionEntity> savedTransactions = transactionService
                .insertTransactionsBatch(transactionsBatch);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedTransactions);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto<TransactionEntity>> updateTransactionById(
            @PathVariable Long id,
            @RequestBody TransactionEntity transaction
    ) {
        ResponseDto<TransactionEntity> responseTransaction  = transactionService
                .updateTransactionById(id, transaction);

        if (responseTransaction.data() != null) {
            return ResponseEntity.status(HttpStatus.OK).body(responseTransaction);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseTransaction);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto<TransactionEntity>> deleteTransactionById(@PathVariable Long id) {
        ResponseDto<TransactionEntity> transactionResponse = transactionService.deleteTransactionById(id);

        if (transactionResponse.data() != null) {
            return ResponseEntity.status(HttpStatus.OK).body(transactionResponse);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(transactionResponse);
        }
    }

    @DeleteMapping
    public void deleteAllTransactions() {
        transactionService.deleteAllTransactions();
    }
}
