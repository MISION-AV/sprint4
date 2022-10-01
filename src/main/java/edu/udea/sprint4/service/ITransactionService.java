package edu.udea.sprint4.service;

import edu.udea.sprint4.entity.Transaction;

import java.util.List;

public interface ITransactionService {
    public List<Transaction> listarTodos();
    public void guardar(Transaction transaction);
    public Transaction buscarPorId(Long id);
    public void eliminar(Long id);
}
