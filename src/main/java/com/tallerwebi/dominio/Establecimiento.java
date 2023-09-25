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
    private Short cantLugaresParaDiscapacitados;
    
    
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
    
    public Short getCantLugaresParaDiscapacitados() {
        return cantLugaresParaDiscapacitados;
    }
    
    public void setCantLugaresParaDiscapacitados(Short cantLugaresParaDiscapacitados) {
        this.cantLugaresParaDiscapacitados = cantLugaresParaDiscapacitados;
    }
}
