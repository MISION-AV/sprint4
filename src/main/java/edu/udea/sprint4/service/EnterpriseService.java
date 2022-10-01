package edu.udea.sprint4.service;

import edu.udea.sprint4.entity.Enterprise;
import edu.udea.sprint4.repository.EnterpriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnterpriseService implements IEnterpriseService{

    @Autowired
    private EnterpriseRepository enterpriseRepository;

    @Override
    public List<Enterprise> listarTodos() {
        return enterpriseRepository.findAll();
    }

    @Override
    public void guardar(Enterprise enterprise) {
        enterpriseRepository.save(enterprise);
    }

    @Override
    public Enterprise buscarPorId(Long id) {
        return enterpriseRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        enterpriseRepository.deleteById(id);
    }
}
