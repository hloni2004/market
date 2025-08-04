package za.ac.cput.service;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Transaction;
import za.ac.cput.repository.TransactionRepository;

import java.util.List;
@Service

public class TransactionService implements ITransactionService {


    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Transaction create(Transaction transaction) {
       return transactionRepository.save(transaction);
    }

    @Override
    public Transaction read(Long aLong) {
        return transactionRepository.findById(aLong).orElse(null);
    }

    @Override
    public Transaction update(Transaction transaction) {
       return transactionRepository.save(transaction);
    }
    @Override
    public boolean delete(Long id) {
        if (transactionRepository.existsById(id)) {
            transactionRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Transaction> getAll() {
        return transactionRepository.findAll();
    }
}
