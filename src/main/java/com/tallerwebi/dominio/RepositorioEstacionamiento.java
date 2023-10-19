package com.tallerwebi.dominio;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioEstacionamiento {
    public boolean registrarEstacionamiento(Estacionamiento e);

    List<Establecimiento> getAllEstablecimientos();

    List<Estacionamiento> getAllEstacionamientos();
}
