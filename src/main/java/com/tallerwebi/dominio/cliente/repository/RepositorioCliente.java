package com.tallerwebi.dominio.cliente.repository;

import com.tallerwebi.dominio.cliente.entity.Cliente;

import java.util.Optional;

public interface RepositorioCliente{

    Optional<Cliente> buscarClientePorId(Long id);

    void guardarCliente(Cliente cliente);

    void modificarCliente(Long id);

    void eliminarCliente(Long id);

    void buscarClientePorVehiculo(String vehiculo);

}
