package com.tallerwebi.dominio;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioEstacionamiento {
    public boolean registrarEstacionamiento(Estacionamiento e);


}
