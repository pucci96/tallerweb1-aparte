package com.tallerwebi.dominio;

import javax.persistence.*;

@Entity
public class Establecimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private int cantidadEstacionamientosDisponibles;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadEstacionamientosDisponibles() {
        return cantidadEstacionamientosDisponibles;
    }

    public void setCantidadEstacionamientosDisponibles(int cantidadEstacionamientosDisponibles) {
        this.cantidadEstacionamientosDisponibles = cantidadEstacionamientosDisponibles;
    }
}
