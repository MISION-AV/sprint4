package edu.udea.sprint4.controller;

import edu.udea.sprint4.entity.Enterprise;
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
public class EnterpriseController {

    @Autowired
    private EnterpriseService enterpriseService;

    //Mostrar empresas
    @GetMapping("/enterprises")
    public String ListarEmpresas(Model model){

        List<Enterprise> listadoEmpresas = enterpriseService.listarTodos();

        model.addAttribute("titulo", "Lista de Empresas");
        model.addAttribute("enterprises", listadoEmpresas);
        return "listar-enterprises";
    }

    //Crear nueva empresa (Muestra Formulario)
    @GetMapping("/enterprises/new")
    public String crear(@DateTimeFormat(pattern = "YYYY-MM-DD") Model model ){

        Enterprise enterprise = new Enterprise();

        model.addAttribute("titulo", "Formulario: Nueva Empresa");
        model.addAttribute("enterprise", enterprise);

        return "new-enterprise";
    }

    //Guarda la Empresa
    @PostMapping("/enterprises/save")
    public String guardar(@ModelAttribute Enterprise enterprise){

        enterpriseService.guardar(enterprise);
        return "redirect:/enterprises";
    }

    //Editar Empresa
    @GetMapping("/enterprises/edit/{id}")
    public String editar(@PathVariable("id") Long id, @DateTimeFormat(pattern = "YYYY-MM-DD") Model model ){

        Enterprise enterprise = null;

        if(id>0){
            enterprise = enterpriseService.buscarPorId(id);

            if(enterprise == null){
                System.out.println("Error: el ID de la empresa no existe");
                return "redirect:/enterprises";
            }
        } else {
            System.out.println("Error: on el ID de la empresa");
            return "redirect:/enterprises";
        }

        model.addAttribute("titulo", "Formulario: Editar Empresa");
        model.addAttribute("enterprise", enterprise);

        return "new-enterprise";
    }

    //Eliminar Empresa
    @GetMapping("/enterprises/delete/{id}")
    public String eliminar(@PathVariable("id") Long id){

        Enterprise enterprise = null;
        if(id>0){
            enterprise = enterpriseService.buscarPorId(id);

            if(enterprise == null){
                System.out.println("Error: el ID de la empresa no existe");
                return "redirect:/enterprises";
            }
        } else {
            System.out.println("Error: on el ID de la empresa");
            return "redirect:/enterprises";
        }

       enterpriseService.eliminar(id);
        return "redirect:/enterprises";
    }
}
