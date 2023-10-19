package com.tallerwebi.dominio;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
public class Estacionamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario", referencedColumnName = "id")
    private Usuario usuario;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "establecimiento", referencedColumnName = "id")
    private Establecimiento establecimiento;

    @Column(name = "fecha")
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
    private LocalDate fecha;

    public Long getId() {
        return id;
    }
    public Usuario getUsuario() {return usuario;}
    public Establecimiento getEstablecimiento() {return establecimiento;}
    public LocalDate getFecha() {return fecha;}
    public void setId(Long id) {
        this.id = id;
    }
    public void setUsuario(Usuario usuario_id) {this.usuario = usuario;}
    public void setEstablecimiento(Establecimiento establecimiento) {this.establecimiento = establecimiento;}
    public void setFecha(LocalDate fecha) {this.fecha = fecha;}

}