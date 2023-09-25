package com.tallerwebi.infraestructura;

import com.tallerwebi.dominio.Establecimiento;
import com.tallerwebi.dominio.EstablecimientoRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EstablecimientoRepositoryImpl implements EstablecimientoRepository {
    
    private SessionFactory sessionFactory;
    
    @Autowired
    public EstablecimientoRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Override
    public void agregarEstablecimiento(Establecimiento establecimiento) {
        sessionFactory.getCurrentSession().save(establecimiento);
    }
    
    @Override
    public Establecimiento buscarEstablecimiento(String direccion) {
        return null;
    }
}
