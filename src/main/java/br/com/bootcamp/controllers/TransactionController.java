package br.com.bootcamp.controllers;

import br.com.bootcamp.models.entities.TransactionEntity;
import br.com.bootcamp.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
