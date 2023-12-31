package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ControladorEstacionamiento {

    private ServicioEstacionamiento serEstacionamiento;

    @Autowired
    public ControladorEstacionamiento(ServicioEstacionamiento serviceEstacionamiento) {
        this.serEstacionamiento = serviceEstacionamiento;
    }

    @RequestMapping("/nuevo-estacionamiento")
    public ModelAndView vistaRegistrarEstacionamiento() {
        ModelMap modelMap = new ModelMap();
        Usuario us = new Usuario();
        Estacionamiento est = new Estacionamiento();
        modelMap.put("estacionamiento", est );
        modelMap.put("establecimientos", serEstacionamiento.buscarListaEstablecimientos());
        return new ModelAndView("nuevo-estacionamiento", modelMap);
    }

    @RequestMapping(value = "/registrar_estacionamiento", method = RequestMethod.POST)
    public ModelAndView registrarEstacionamiento(@ModelAttribute("estacionamiento")Estacionamiento e) {
        ModelMap modelMap = new ModelMap();
        try {
            serEstacionamiento.agregarEstacionamiento(e);
        } catch (Exception exception) {
            //modelMap.put("error", exception.getMessage());
            modelMap.put("error", "Por favor, elegir un establecimiento valido");
            return new ModelAndView("nuevo-estacionamiento", modelMap);
        }
        return new ModelAndView("home");
    }

    @RequestMapping(value= "listaEstacionamientos", method = RequestMethod.GET)
    public ModelAndView listaEstacionamientos(){
        ModelAndView listaEstablecimientos = new ModelAndView("listaEstacionamientos");
        listaEstablecimientos.addObject("listaEstacionamientos", serEstacionamiento.buscarListaEstacionamientos());
        return listaEstablecimientos;
    }
}
