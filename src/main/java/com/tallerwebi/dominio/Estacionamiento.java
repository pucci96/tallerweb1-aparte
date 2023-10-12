package com.tallerwebi.dominio;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

public class Estacionamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario_id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "establecimiento_id", referencedColumnName = "id")
    private Usuario establecimiento_id;

    @Column(name = "fecha")
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
    private LocalDate fecha;

    public Long getId() {
        return id;
    }
    public Usuario getUsuario_id() {return usuario_id;}
    public Usuario getEstablecimiento_id() {return establecimiento_id;}
    public LocalDate getFecha() {return fecha;}
    public void setId(Long id) {
        this.id = id;
    }
    public void setUsuario_id(Usuario usuario_id) {this.usuario_id = usuario_id;}
    public void setEstablecimiento_id(Usuario establecimiento_id) {this.establecimiento_id = establecimiento_id;}
    public void setFecha(LocalDate fecha) {this.fecha = fecha;}
}