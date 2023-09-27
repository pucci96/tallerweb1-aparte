package com.tallerwebi.dominio;

import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioEstablecimiento {

    public int obtenerCantidadEstacionamientosDisponibles(Long establecimientoId);

    public void actualizarCantidadEstacionamientos(Long establecimientoId, int nuevaCantidad);

    public void incrementarCantidadEstacionamientos(Long establecimientoId, int cantidadIncremento);
    public void decrementarCantidadEstacionamientos(Long establecimientoId, int cantidadDecremento);

    Establecimiento findById(Long id);
    Establecimiento findByDireccion(String direccion);
    Establecimiento save(Establecimiento establecimiento);

    void update(Establecimiento establecimiento);


}
