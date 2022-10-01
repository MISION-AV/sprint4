package edu.udea.sprint4.controller;

import edu.udea.sprint4.entity.Transaction;
import edu.udea.sprint4.service.EmployeeService;
import edu.udea.sprint4.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    //Mostrar Transacciones
    @GetMapping("/transactions")
    public String ListarTransacciones(Model model){

        model.addAttribute("titulo", "Lista de Transacciones");

        return "list-transactions";
    }
}
