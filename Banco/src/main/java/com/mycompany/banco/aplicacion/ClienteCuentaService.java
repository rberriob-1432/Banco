package com.mycompany.banco.aplicacion;

import com.mycompany.banco.Dominio.Cliente;
import com.mycompany.banco.Dominio.Cuenta;

public class ClienteCuentaService {
    private ClienteRepository clienteRepo;
    private CuentaRepository cuentaRepo;

    public ClienteCuentaService(ClienteRepository cr, CuentaRepository ccr) {
        this.clienteRepo = cr;
        this.cuentaRepo = ccr;
    }

    public boolean asignarCuentaACliente(long idCliente, Cuenta cuenta) {
        Cliente cliente = clienteRepo.buscarCliente(idCliente);
        if (cliente == null) return false;

        if (!cuentaRepo.agregarCuenta(cuenta)) return false;

        cliente.agregarCuenta(cuenta);
        return true;
    }

    public boolean eliminarCuentaDeCliente(long idCliente, long numeroCuenta) {
        Cliente cliente = clienteRepo.buscarCliente(idCliente);
        if (cliente == null) return false;

        Cuenta cuentaAEliminar = null;
        for (Cuenta c : cliente.getCuentas()) {
            if (c.getNumeroCuenta() == numeroCuenta) {
                cuentaAEliminar = c;
                break;
            }
        }

        if (cuentaAEliminar == null) return false;

        cliente.getCuentas().remove(cuentaAEliminar);
        return cuentaRepo.eliminarCuenta(cuentaAEliminar);
    }
}
