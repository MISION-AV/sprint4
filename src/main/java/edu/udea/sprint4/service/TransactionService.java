package edu.udea.sprint4.service;

import edu.udea.sprint4.entity.Transaction;
import edu.udea.sprint4.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService implements ITransactionService{

    private TransactionRepository transactionRepository;

    @Override
    public List<Transaction> listarTodos() {
        return (List<Transaction>) transactionRepository.findAll();
    }

    @Override
    public void guardar(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    @Override
    public Transaction buscarPorId(Long id) {
        return transactionRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        transactionRepository.deleteById(id);
    }
}
