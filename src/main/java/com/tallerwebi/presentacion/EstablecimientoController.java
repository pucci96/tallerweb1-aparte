package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.Establecimiento;
import com.tallerwebi.dominio.EstablecimientoService;
import com.tallerwebi.dominio.EstablecimientoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EstablecimientoController {
    
    private EstablecimientoService service;
    
    @Autowired
    public EstablecimientoController(EstablecimientoService service) {
        this.service = service;
    }
    
    @RequestMapping("/nuevo-establecimiento")
    public ModelAndView vistaRegistrarEstablecimiento() {
        ModelMap modelMap = new ModelMap();
        modelMap.put("establecimiento", new Establecimiento());
        
        return new ModelAndView("nuevo-establecimiento", modelMap);
    }
    
    @RequestMapping(value = "/procesar-registro", method = RequestMethod.POST)
    public ModelAndView registrarEstablecimiento(@ModelAttribute("establecimiento") Establecimiento establecimiento) {
        service.agregarEstablecimiento(establecimiento);
        
        return new ModelAndView("home");
    }

}
