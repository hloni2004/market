package za.ac.cput.service;

import za.ac.cput.domain.Transaction;

import java.util.List;

public interface ITransactionService extends IService<Transaction, Integer> {

    boolean delete(String id);
    List<Transaction> getAll();
}
