package com.tallerwebi.dominio;

import java.util.List;

public interface ServicioEstacionamiento {
    void agregarEstacionamiento(Estacionamiento e) throws Exception;
    List<Establecimiento> buscarListaEstablecimientos();

    List<Estacionamiento> buscarListaEstacionamientos();
}
