package com.tallerwebi.dominio.reserva;


import com.tallerwebi.dominio.Establecimiento;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//@Entity
public class Reserva {

    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReserva;
    //@Column(name="Fecha", nullable=false);
    private LocalDateTime fechaReserva;
    private String cliente;
    private String vehiculo;
    private List<Establecimiento> establecimientosDisponibles = new ArrayList<>();
    public Reserva(Long idReserva, LocalDateTime fechaReserva, String cliente, String vehiculo, List establecimientosDisponibles){
        this.idReserva= idReserva;
        this.fechaReserva = fechaReserva;
        this.cliente=cliente;
        this.vehiculo= vehiculo;
        this.establecimientosDisponibles= establecimientosDisponibles;
    }
    public LocalDateTime getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDateTime fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Long getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Long idReserva) {
        this.idReserva = idReserva;
    }
}
