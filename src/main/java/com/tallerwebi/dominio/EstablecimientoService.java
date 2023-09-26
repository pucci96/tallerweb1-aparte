package com.tallerwebi.dominio;


import com.tallerwebi.dominio.excepcion.EstablecimientoExistenteException;

public interface EstablecimientoService {

    void agregarEstablecimiento(Establecimiento establecimiento) throws EstablecimientoExistenteException;
    Establecimiento buscarEstablecimiento(String direccion);
    
}
