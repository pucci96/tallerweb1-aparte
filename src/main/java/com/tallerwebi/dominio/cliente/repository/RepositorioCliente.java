package com.tallerwebi.dominio.cliente.repository;

import com.tallerwebi.dominio.cliente.entity.Cliente;


public interface RepositorioCliente{

    Cliente buscarClientePorId(Long id);

    void guardarCliente(Cliente cliente);

    void modificarCliente(Cliente cliente);

    void eliminarCliente(Cliente cliente);

    Cliente buscarClientePorVehiculo(String vehiculo);

}
