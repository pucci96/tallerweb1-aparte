package com.tallerwebi.dominio.reserva;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository("RepositorioReserva")
public class RepositorioReservaimpl implements RepositorioReserva{
        @Autowired
        private SessionFactory sessionFactory;

        @Override
        public Reserva buscarReserva(Long id) {

            final Session session = sessionFactory.getCurrentSession();

            return (Reserva) session.createCriteria(Reserva.class)
                    .add(Restrictions.eq("id",id))
                    .uniqueResult();
        }

        @Override
        public void guardarReserva(Reserva reserva) {
            sessionFactory.getCurrentSession().save(reserva);
        }

        @Override
        public void modificarReserva(Reserva reserva) {
            sessionFactory.getCurrentSession().update(reserva);
        }

    @Override
    public void eliminarReserva(Long id) {
        final Session session = sessionFactory.getCurrentSession();
        Reserva reserva = session.get(Reserva.class, id);
        if (reserva != null) {
            session.delete(reserva);
        }
    }

}
