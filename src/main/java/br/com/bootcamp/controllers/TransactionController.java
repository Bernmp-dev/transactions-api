package br.com.bootcamp.controllers;

import br.com.bootcamp.exceptions.TransactionNotFoundException;
import br.com.bootcamp.models.dtos.ResponseDto;
import br.com.bootcamp.models.entities.TransactionEntity;
import br.com.bootcamp.models.interfaces.CategorySumProjection;
import br.com.bootcamp.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TransactionEntity> getAllTransactionsOrByDate(
            @RequestParam(value = "date", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date
    ) {
        if (date != null) {
            return transactionService.getTransactionsByDate(date);
        } else {
            return transactionService.getAllTransactions();
        }
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TransactionEntity getTransactionById(@PathVariable Long id) {

        return transactionService
                .getTransactionById(id)
                .orElseThrow(TransactionNotFoundException::new);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TransactionEntity insertTransaction(
            @RequestBody TransactionEntity transaction
    ) {
        return transactionService.insertTransaction(transaction);
    }

    @PostMapping("/batch")
    @ResponseStatus(HttpStatus.CREATED)
    public List<TransactionEntity> insertTransactionsBatch(
            @RequestBody List<TransactionEntity> transactionsBatch
    ) {

        return transactionService.insertTransactionsBatch(transactionsBatch);
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
    @ResponseStatus(HttpStatus.OK)
    public void deleteAllTransactions() {
        transactionService.deleteAllTransactions();
    }

    @GetMapping("/sum")
    @ResponseStatus(HttpStatus.OK)
    public List<CategorySumProjection> sumValuesByCategory(
            @RequestParam(value = "category", required = false) String category
    ) {
        List<CategorySumProjection> sums = transactionService.sumValuesByCategory(category);

        if (sums.isEmpty()) {
            throw new TransactionNotFoundException();
        }

        return sums;
    }
}
