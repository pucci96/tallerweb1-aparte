package com.tallerwebi.dominio.reserva;

import com.tallerwebi.dominio.reserva.Reserva;

public interface RepositorioReserva {

    Reserva buscarReserva(Long id);
    void guardarReserva(Reserva reserva);
    void eliminarReserva(Long id);
    void modificarReserva(Reserva reserva);

}
