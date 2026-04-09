package com.mycompany.banco.aplicacion;
import com.mycompany.banco.Dominio.Cuenta;
public class Depositar {
    public void depositar(Cuenta cuenta, double monto) {
        if (monto <= 0) {
            return;
        }
        double saldoActual = cuenta.getSaldo();
        cuenta.setSaldo(saldoActual + monto);
    }
}
