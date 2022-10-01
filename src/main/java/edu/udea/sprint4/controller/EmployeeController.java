package edu.udea.sprint4.controller;

import edu.udea.sprint4.entity.Employee;
import edu.udea.sprint4.entity.Enterprise;
import edu.udea.sprint4.service.EmployeeService;
import edu.udea.sprint4.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EnterpriseService enterpriseService;

    //Mostrar Empleados
    @GetMapping("/employees")
    public String listarEmpleados(Model model){

        List<Employee> employeeList = employeeService.listarTodos();

        model.addAttribute("titulo", "Lista de Empleados");
        model.addAttribute("employees", employeeList);
        return "list-employees";
    }

    //Crear nuevo empleado (Muestra Formulario)
    @GetMapping("/employees/new")
    public String crear(@DateTimeFormat(pattern = "YYYY-MM-DD") Model model ){

        Employee employee = new Employee();
        List<Enterprise> enterpriseList = enterpriseService.listarTodos();

        model.addAttribute("titulo", "Formulario: Nuevo Empleado");
        model.addAttribute("employee", employee);
        model.addAttribute("enterprises", enterpriseList);

        return "new-employee";
    }

    //Guarda el Empleado
    @PostMapping("/employees/save")
    public String guardar(@ModelAttribute Employee employee){

        employeeService.guardar(employee);

        return "redirect:/employees";
    }

    //Editar Empleado
    @GetMapping("/employees/edit/{id}")
    public String editar(@PathVariable("id") Long id, @DateTimeFormat(pattern = "YYYY-MM-DD") Model model ){

        Employee employee = employeeService.buscarPorId(id);
        List<Enterprise> enterpriseList = enterpriseService.listarTodos();

        model.addAttribute("titulo", "Formulario: Editar Empleado");
        model.addAttribute("employee", employee);
        model.addAttribute("enterprises", enterpriseList);

        return "new-employee";
    }

    //Eliminar Empleado
    @GetMapping("/employees/delete/{id}")
    public String eliminar(@PathVariable("id") Long id){

        employeeService.eliminar(id);

        return "redirect:/employees";
    }
}
