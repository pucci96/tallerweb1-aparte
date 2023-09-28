package com.tallerwebi.infraestructura;

import com.tallerwebi.dominio.Establecimiento;
import com.tallerwebi.dominio.RepositorioEstablecimiento;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("repositorioEstablecimiento")
public class RepositorioEstablecimientoImpl implements RepositorioEstablecimiento {

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioEstablecimientoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public int obtenerCantidadEstacionamientosDisponibles(Long establecimientoId) {
        final Session session = sessionFactory.getCurrentSession();
        Establecimiento establecimiento = session.get(Establecimiento.class, establecimientoId);
        if (establecimiento != null) {
            return establecimiento.getCantidadEstacionamientosDisponibles();
        }
        return 0; // Otra acción apropiada en caso de que el establecimiento no exista
    }

    @Override
    public void actualizarCantidadEstacionamientos(Long establecimientoId, int nuevaCantidad) {
        final Session session = sessionFactory.getCurrentSession();
        Establecimiento establecimiento = session.get(Establecimiento.class, establecimientoId);
        if (establecimiento != null) {
            establecimiento.setCantidadEstacionamientosDisponibles(nuevaCantidad);
            session.update(establecimiento);
        }
        // manejar casos en los que el establecimiento no exista
    }

    @Override
    public void incrementarCantidadEstacionamientos(Long establecimientoId, int cantidadIncremento) {
        final Session session = sessionFactory.getCurrentSession();
        Establecimiento establecimiento = session.get(Establecimiento.class, establecimientoId);
        if (establecimiento != null) {
            int cantidadActual = establecimiento.getCantidadEstacionamientosDisponibles();
            establecimiento.setCantidadEstacionamientosDisponibles(cantidadActual + cantidadIncremento);
            session.update(establecimiento);
        }
        // manejar casos en los que el establecimiento no exista
    }

    @Override
    public void decrementarCantidadEstacionamientos(Long establecimientoId, int cantidadDecremento) {
        final Session session = sessionFactory.getCurrentSession();
        Establecimiento establecimiento = session.get(Establecimiento.class, establecimientoId);
        if (establecimiento != null) {
            int cantidadActual = establecimiento.getCantidadEstacionamientosDisponibles();
            int nuevaCantidad = Math.max(0, cantidadActual - cantidadDecremento); // Aseguramos que no sea negativo
            establecimiento.setCantidadEstacionamientosDisponibles(nuevaCantidad);
            session.update(establecimiento);
        }
        // manejar casos en los que el establecimiento no exista
    }

    @Override
    public Establecimiento findById(Long id) {
        final Session session = sessionFactory.getCurrentSession();
        return session.get(Establecimiento.class, id);
    }
    
    // falta testear este metodo
    @Override
    public Establecimiento findByDireccion(String direccion) {
        final Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Establecimiento WHERE direccion = :direccion");
        query.setParameter("direccion", direccion);
        return (Establecimiento) query.uniqueResult();
    }
    
    @Override
    public Establecimiento save(Establecimiento establecimiento) {
        sessionFactory.getCurrentSession().save(establecimiento);
        return establecimiento;
    }

    @Override
    public void update(Establecimiento establecimiento) {
        sessionFactory.getCurrentSession().update(establecimiento);
    }

    // Agrega otros métodos personalizados según tus necesidades

}
