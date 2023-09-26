package com.tallerwebi.dominio;


import javax.persistence.*;

@Entity
@Table(name = "establecimiento")
public class Establecimiento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String direccion;
    private Integer capacidadMaxima;
    private Integer cantLugaresParaDiscapacitados;
    
    public Establecimiento() {
    }
    
    public Establecimiento(Long id, String direccion, Integer capacidadMaxima, Integer cantLugaresParaDiscapacitados) {
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
    
    public String getDireccion() {
        return direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public Integer getCapacidadMaxima() {
        return capacidadMaxima;
    }
    
    public void setCapacidadMaxima(Integer capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }
    
    public Integer getCantLugaresParaDiscapacitados() {
        return cantLugaresParaDiscapacitados;
    }
    
    public void setCantLugaresParaDiscapacitados(Integer cantLugaresParaDiscapacitados) {
        this.cantLugaresParaDiscapacitados = cantLugaresParaDiscapacitados;
    }
}
