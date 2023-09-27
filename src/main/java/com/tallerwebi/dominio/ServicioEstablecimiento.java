package com.tallerwebi.dominio;


import com.tallerwebi.dominio.excepcion.EstablecimientoExistenteException;

public interface ServicioEstablecimiento {

    void agregarEstablecimiento(Establecimiento establecimiento) throws EstablecimientoExistenteException;
    Establecimiento buscarEstablecimiento(String direccion);
    
}
