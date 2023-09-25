package com.tallerwebi.dominio;

public interface EstablecimientoRepository {
    
    void agregarEstablecimiento(Establecimiento establecimiento);
    Establecimiento buscarEstablecimiento(String direccion);
    
}
