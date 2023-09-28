package com.tallerwebi.dominio.excepcion;

public class ReservaExistente extends Exception{

    public ReservaExistente(String mensaje) {
        super(mensaje);
    }
}
