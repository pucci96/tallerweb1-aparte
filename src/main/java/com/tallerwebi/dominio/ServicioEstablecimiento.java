package com.tallerwebi.dominio;


import com.tallerwebi.dominio.excepcion.EstablecimientoExistenteException;

import java.util.List;

public interface ServicioEstablecimiento {

    void agregarEstablecimiento(Establecimiento establecimiento) throws EstablecimientoExistenteException;
    Establecimiento buscarEstablecimiento(String direccion);

    List<Establecimiento> buscarEstablecimiento();
    
}
