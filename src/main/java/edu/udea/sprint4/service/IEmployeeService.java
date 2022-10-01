package edu.udea.sprint4.service;

import edu.udea.sprint4.entity.Employee;

import java.util.List;

public interface IEmployeeService {
    public List<Employee> listarTodos();
    public void guardar(Employee employee);
    public Employee buscarPorId(Long id);
    public void eliminar(Long id);
}
