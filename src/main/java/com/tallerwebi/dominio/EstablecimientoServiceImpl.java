package com.tallerwebi.dominio;

import com.tallerwebi.dominio.excepcion.EstablecimientoExistenteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
@Transactional
public class EstablecimientoServiceImpl implements EstablecimientoService {
    
    private EstablecimientoRepository establecimientoRepository;
    
    @Autowired
    public EstablecimientoServiceImpl(EstablecimientoRepository establecimientoRepository) {
        this.establecimientoRepository = establecimientoRepository;
    }
    
    @Override
    public void agregarEstablecimiento(Establecimiento establecimiento) throws EstablecimientoExistenteException {
        Establecimiento establecimientoExistente = buscarEstablecimiento(establecimiento.getDireccion());
        
        if (establecimientoExistente == null) {
            establecimientoRepository.agregarEstablecimiento(establecimiento);
        } else {
            throw new EstablecimientoExistenteException();
        }
    }
    
    @Override
    public Establecimiento buscarEstablecimiento(String direccion) {
        return establecimientoRepository.buscarEstablecimiento(direccion);
    }
}
