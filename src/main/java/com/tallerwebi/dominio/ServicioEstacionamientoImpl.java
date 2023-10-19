package com.tallerwebi.dominio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ServicioEstacionamientoImpl implements ServicioEstacionamiento {
    private RepositorioEstacionamiento repo;

    @Autowired
    public ServicioEstacionamientoImpl(RepositorioEstacionamiento repositorio) {
        this.repo = repositorio;
    }
    @Override
    public void agregarEstacionamiento(Estacionamiento e) throws Exception {
        if(!repo.registrarEstacionamiento(e)){
            throw new Exception("Por favor, elegir un establecimiento valido");
        }
    }

    @Override
    public List<Establecimiento> buscarListaEstablecimientos() {
        return repo.getAllEstablecimientos();
    }

    @Override
    public List<Estacionamiento> buscarListaEstacionamientos() {
        return repo.getAllEstacionamientos();
    }
}
