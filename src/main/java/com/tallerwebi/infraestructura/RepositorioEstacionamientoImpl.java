package com.tallerwebi.infraestructura;

import com.tallerwebi.dominio.Estacionamiento;
import com.tallerwebi.dominio.RepositorioEstacionamiento;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

public class RepositorioEstacionamientoImpl implements RepositorioEstacionamiento {
    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioEstablecimientoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public boolean registrarEstacionamiento(Estacionamiento e){
        final Session session = sessionFactory.getCurrentSession();
        if(e.getUsuario_id() != null && e.getEstablecimiento_id() != null){
            sessionFactory.getCurrentSession().save(e);
            return true;
        }
        return false; //Al no tener los datos esenciales, no guarda
    }
}
