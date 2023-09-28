package com.tallerwebi.dominio;

import com.tallerwebi.dominio.excepcion.EstablecimientoExistenteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
@Transactional
public class ServicioEstablecimientoImpl implements ServicioEstablecimiento {
    
    private RepositorioEstablecimiento repositorioEstablecimiento;
    
    @Autowired
    public ServicioEstablecimientoImpl(RepositorioEstablecimiento repositorio) {
        this.repositorioEstablecimiento = repositorio;
    }
    
    @Override
    public void agregarEstablecimiento(Establecimiento establecimiento) throws EstablecimientoExistenteException {
        Establecimiento establecimientoExistente = buscarEstablecimiento(establecimiento.getDireccion());
        
        if (establecimientoExistente == null) {
            repositorioEstablecimiento.save(establecimiento);
        } else {
            throw new EstablecimientoExistenteException();
        }
    }
    
    @Override
    public Establecimiento buscarEstablecimiento(String direccion) {
        return repositorioEstablecimiento.findByDireccion(direccion);
    }
    
}
