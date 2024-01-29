package br.com.bootcamp.services;

import br.com.bootcamp.models.entities.TransactionEntity;
import br.com.bootcamp.models.repositories.TransactionRepo;

import java.util.List;

public class TransactionService {
    private TransactionRepo transactionRepo;

    public List<TransactionEntity> getAllTransactions() {
        return transactionRepo.findAll();
    }
}
