package br.com.bootcamp.services;

import br.com.bootcamp.models.entities.TransactionEntity;
import br.com.bootcamp.models.repositories.TransactionRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    private TransactionRepo transactionRepo;

    public List<TransactionEntity> getAllTransactions() {
        return transactionRepo.findAll();
    }
}
