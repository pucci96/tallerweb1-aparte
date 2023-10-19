package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.Establecimiento;
import com.tallerwebi.dominio.ServicioEstablecimiento;
import com.tallerwebi.dominio.excepcion.EstablecimientoExistenteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ControladorEstablecimiento {
    
    private ServicioEstablecimiento servicio;
    
    @Autowired
    public ControladorEstablecimiento(ServicioEstablecimiento service) {
        this.servicio = service;
    }
    
    @RequestMapping("/nuevo-establecimiento")
    public ModelAndView vistaRegistrarEstablecimiento() {
        ModelMap modelMap = new ModelMap();
        modelMap.put("establecimiento", new Establecimiento());
        
        return new ModelAndView("nuevo-establecimiento", modelMap);
    }
    
    @RequestMapping(value = "/procesar-registro", method = RequestMethod.POST)
    public ModelAndView registrarEstablecimiento(@ModelAttribute("establecimiento") Establecimiento establecimiento) {
        ModelMap modelMap = new ModelMap();
        
        try {
            servicio.agregarEstablecimiento(establecimiento);
        } catch (EstablecimientoExistenteException e) {
            modelMap.put("error", "Error: Ya existe un establecimiento en " + establecimiento.getDireccion());
            return new ModelAndView("nuevo-establecimiento", modelMap);
        }
        
        return new ModelAndView("home");
    }

    @RequestMapping(value= "listaEstablecimientos", method = RequestMethod.GET)
    public ModelAndView listaEstablecimientos(){
        ModelAndView listaEstablecimientos = new ModelAndView("listaEstablecimientos");
        listaEstablecimientos.addObject("listaEstablecimientos", servicio.buscarEstablecimiento());
        return listaEstablecimientos;
    }

    @ModelAttribute("listaEstablecimientos")
    public List<Establecimiento> estList(){
        return servicio.buscarEstablecimiento();
    }

}
