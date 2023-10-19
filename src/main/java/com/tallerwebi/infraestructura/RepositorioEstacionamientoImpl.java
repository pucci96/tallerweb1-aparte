package com.tallerwebi.infraestructura;

import com.tallerwebi.dominio.Establecimiento;
import com.tallerwebi.dominio.Estacionamiento;
import com.tallerwebi.dominio.RepositorioEstacionamiento;
import com.tallerwebi.dominio.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository("repositorioEstacionamiento")
public class RepositorioEstacionamientoImpl implements RepositorioEstacionamiento {
    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioEstacionamientoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public boolean registrarEstacionamiento(Estacionamiento e){
        final Session session = sessionFactory.getCurrentSession();
        Usuario dummy = new Usuario();
        //dummy.setId(999L);
        //dummy.setEmail("testPucci@gmail.com");
        e.setFecha(LocalDate.now());
        e.setUsuario(dummy);
        if(e.getEstablecimiento() != null && e.getUsuario() != null){
            //TO-DO: Que decremente el valor de la capacidad disponible
            sessionFactory.getCurrentSession().save(e);
            return true;
        }
        return false; //Al no tener los datos esenciales, no guarda
    }

    @Override
    public List<Establecimiento> getAllEstablecimientos() {
        final Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Establecimiento");
        List<Establecimiento> lista;
        lista = (List<Establecimiento>) query.getResultList();
        return lista;
    }

    @Override
    public List<Estacionamiento> getAllEstacionamientos() {
        final Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Estacionamiento");
        List<Estacionamiento> lista;
        lista = (List<Estacionamiento>) query.getResultList();
        return lista;
    }
}
