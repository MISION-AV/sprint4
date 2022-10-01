package edu.udea.sprint4.service;

import edu.udea.sprint4.entity.Enterprise;

import java.util.List;

public interface IEnterpriseService {
    public List<Enterprise> listarTodos();
    public void guardar(Enterprise enterprise);
    public Enterprise buscarPorId(Long id);
    public void eliminar(Long id);
}
