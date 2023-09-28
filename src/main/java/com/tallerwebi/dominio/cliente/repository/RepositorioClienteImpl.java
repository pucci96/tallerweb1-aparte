package com.tallerwebi.dominio.cliente.repository;

import com.tallerwebi.dominio.cliente.entity.Cliente;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository("repositorioCliente")
public class RepositorioClienteImpl implements RepositorioCliente{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Cliente buscarClientePorId(Long id) {

        final Session session = sessionFactory.getCurrentSession();

        return (Cliente) session.createCriteria(Cliente.class)
                .add(Restrictions.eq("id",id))
                .uniqueResult();
    }

    @Override
    public void guardarCliente(Cliente cliente) {
        sessionFactory.getCurrentSession().save(cliente);
    }

    @Override
    public void modificarCliente(Cliente cliente) {
        sessionFactory.getCurrentSession().update(cliente);
    }

    @Override
    public void eliminarCliente(Cliente cliente) {
        sessionFactory.getCurrentSession().delete(cliente);
    }

    @Override
    public Cliente buscarClientePorVehiculo(String vehiculo) {

        final Session session = sessionFactory.getCurrentSession();

        return (Cliente) session.createCriteria(Cliente.class)
                .add(Restrictions.eq("vehiculo",vehiculo))
                .uniqueResult();

    }
}
