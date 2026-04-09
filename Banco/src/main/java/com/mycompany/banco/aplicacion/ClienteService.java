package com.mycompany.banco.aplicacion;

import com.mycompany.banco.Dominio.Cliente;
import com.mycompany.banco.Dominio.Cuenta;
import java.util.ArrayList;
import java.util.List;

public class ClienteService {

    private List<Cliente> clientes = new ArrayList<>();
    private List<Cuenta> cuentas = new ArrayList<>(); // lista global de cuentas

    // Buscar cliente simple
    public Cliente buscarCliente(long idCliente) {
        for (Cliente c : clientes) {
            if (c.getId() == idCliente) return c;
        }
        return null;
    }

    // Agregar cliente
    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    // Eliminar cuenta de cliente y de lista global
    public boolean eliminarCuentaDeCliente(long idCliente, long numeroCuenta) {
        Cliente cliente = buscarCliente(idCliente);
        if (cliente == null) {
            System.out.println("Cliente no encontrado");
            return false;
        }

        Cuenta cuentaAEliminar = null;
        for (Cuenta c : cliente.getCuentas()) {
            if (c.getNumeroCuenta() == numeroCuenta) {
                cuentaAEliminar = c;
                break;
            }
        }

        if (cuentaAEliminar == null) {
            System.out.println("Cuenta no encontrada en este cliente");
            return false;
        }

        cliente.getCuentas().remove(cuentaAEliminar);

        // Eliminar también de la lista global
        return cuentas.remove(cuentaAEliminar);
    }

    // Agregar cuenta global (opcional)
    public void agregarCuentaGlobal(Cuenta cuenta) {
        cuentas.add(cuenta);
    }
}