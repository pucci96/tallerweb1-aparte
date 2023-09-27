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
    private String direccion;
//    tanto los atributos capacidadMaxima y cantLugaresParaDiscapacitados creo
//    que deberian ir en la clase estacionamiento
    private int capacidadMaxima;
    private int cantLugaresParaDiscapacitados;
    
    public Establecimiento() {
    }
    
    public Establecimiento(Long id, String direccion, int capacidadMaxima, int cantLugaresParaDiscapacitados) {
        this.id = id;
        this.direccion = direccion;
        this.capacidadMaxima = capacidadMaxima;
        this.cantLugaresParaDiscapacitados = cantLugaresParaDiscapacitados;
    }
    
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
    
    public String getDireccion() {
        return direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }
    
    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }
    
    public int getCantLugaresParaDiscapacitados() {
        return cantLugaresParaDiscapacitados;
    }
    
    public void setCantLugaresParaDiscapacitados(int cantLugaresParaDiscapacitados) {
        this.cantLugaresParaDiscapacitados = cantLugaresParaDiscapacitados;
    }
    
    public int getCantidadEstacionamientosDisponibles() {
        return cantidadEstacionamientosDisponibles;
    }
    
    public void setCantidadEstacionamientosDisponibles(int cantidadEstacionamientosDisponibles) {
        this.cantidadEstacionamientosDisponibles = cantidadEstacionamientosDisponibles;
    }
    
}
