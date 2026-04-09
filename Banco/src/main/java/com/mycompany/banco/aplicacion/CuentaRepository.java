package com.mycompany.banco.aplicacion;

import com.mycompany.banco.Dominio.Cuenta;
import java.util.List;
import java.util.ArrayList;

public class CuentaRepository {
    private List<Cuenta> cuentas = new ArrayList<>();

    public boolean agregarCuenta(Cuenta cuenta) {
        if (buscarCuenta(cuenta.getNumeroCuenta()) != null) return false;
        cuentas.add(cuenta);
        return true;
    }

    public Cuenta buscarCuenta(long numeroCuenta) {
        for (Cuenta c : cuentas) {
            if (c.getNumeroCuenta() == numeroCuenta) return c;
        }
        return null;
    }

    public boolean eliminarCuenta(Cuenta cuenta) {
        return cuentas.remove(cuenta);
    }

    public List<Cuenta> listarCuentas() {
        return new ArrayList<>(cuentas);
    }
}
