package com.tallerwebi.dominio;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioEstablecimiento {

    public int obtenerCantidadEstacionamientosDisponibles(Long establecimientoId);

    public void actualizarCantidadEstacionamientos(Long establecimientoId, int nuevaCantidad);

    public void incrementarCantidadEstacionamientos(Long establecimientoId, int cantidadIncremento);
    public void decrementarCantidadEstacionamientos(Long establecimientoId, int cantidadDecremento);

    Establecimiento findById(Long id);
    Establecimiento findByDireccion(String direccion);
    Establecimiento save(Establecimiento establecimiento);

    List<Establecimiento> findAll();

    void update(Establecimiento establecimiento);


}
