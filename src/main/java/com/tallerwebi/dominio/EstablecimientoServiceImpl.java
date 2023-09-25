package com.tallerwebi.dominio;

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
    
    public void agregarEstablecimiento(Establecimiento establecimiento) {
        establecimientoRepository.agregarEstablecimiento(establecimiento);
    }
    
}
