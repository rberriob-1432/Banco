package com.mycompany.banco.aplicacion;

import com.mycompany.banco.Dominio.Cliente;
import java.util.List;
import java.util.ArrayList;

public class ClienteRepository implements BuscableCliente {
    private List<Cliente> clientes = new ArrayList<>();

    @Override
    public Cliente buscarCliente(long id) {
        for (Cliente c : clientes) {
            if (c.getId() == id) return c;
        }
        return null;
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public List<Cliente> listarClientes() {
        return new ArrayList<>(clientes);
    }
}