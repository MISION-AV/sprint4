package edu.udea.sprint4.service;

import edu.udea.sprint4.entity.Employee;
import edu.udea.sprint4.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> listarTodos() {
        return (List<Employee>) employeeRepository.findAll();
    }

    @Override
    public void guardar(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee buscarPorId(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        employeeRepository.deleteById(id);
    }
}
