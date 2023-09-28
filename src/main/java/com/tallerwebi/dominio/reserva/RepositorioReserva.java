package com.tallerwebi.dominio.reserva;

import com.tallerwebi.dominio.excepcion.ReservaExistente;
import com.tallerwebi.dominio.reserva.Reserva;

public interface RepositorioReserva {

    Reserva buscarReserva(Long id);
    void guardarReserva(Reserva reserva) throws ReservaExistente;
    void eliminarReserva(Long id);
    void modificarReserva(Reserva reserva);

}
