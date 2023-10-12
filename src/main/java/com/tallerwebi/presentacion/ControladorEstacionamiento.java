package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.Establecimiento;
import com.tallerwebi.dominio.Estacionamiento;
import com.tallerwebi.dominio.ServicioEstacionamiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorEstacionamiento {

    private ServicioEstacionamiento servicio;

    @Autowired
    public ControladorEstacionamiento(ServicioEstacionamiento service) {
        this.servicio = service;
    }

    @RequestMapping("/nuevo-estacionamiento")
    public ModelAndView vistaRegistrarEstacionamiento() {
        ModelMap modelMap = new ModelMap();
        modelMap.put("estacionamiento", new Establecimiento());

        return new ModelAndView("nuevo-estacionamiento", modelMap);
    }

    @RequestMapping(value = "/registrar_estacionamiento", method = RequestMethod.POST)
    public ModelAndView registrarEstacionamiento(@ModelAttribute("estacionamiento")Estacionamiento e) {
        ModelMap modelMap = new ModelMap();
        try {
            servicio.agregarEstacionamiento(e);
        } catch (Exception exception) {
            modelMap.put("error", exception.getMessage());
            return new ModelAndView("nuevo-estacionamiento", modelMap);
        }
        return new ModelAndView("home");
    }
}
