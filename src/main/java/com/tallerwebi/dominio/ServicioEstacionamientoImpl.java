package com.tallerwebi.dominio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
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
            throw new Exception("Verificar ID de Usuario / ID de Establecimiento");
        }
    }
}
