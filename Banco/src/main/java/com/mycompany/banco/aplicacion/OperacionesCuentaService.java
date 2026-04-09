package com.mycompany.banco.aplicacion;

import com.mycompany.banco.Dominio.Cuenta;

public class OperacionesCuentaService {
    private CuentaRepository cuentaRepo;

    public OperacionesCuentaService(CuentaRepository repo) {
        this.cuentaRepo = repo;
    }

    public void depositar(long numeroCuenta, double monto) {
        Cuenta cuenta = cuentaRepo.buscarCuenta(numeroCuenta);
        if (cuenta != null) {
            cuenta.depositar(monto); 
        } else {
            System.out.println("Cuenta no encontrada");
        }
    }

    public void retirar(long numeroCuenta, double monto) {
        Cuenta cuenta = cuentaRepo.buscarCuenta(numeroCuenta);
        if (cuenta != null) {
            if (!cuenta.retirar(monto)) { 
                System.out.println("Fondos insuficientes o monto inválido");
            }
        } else {
            System.out.println("Cuenta no encontrada");
        }
    }

    public void mostrarCuenta(long numeroCuenta) {
        Cuenta cuenta = cuentaRepo.buscarCuenta(numeroCuenta);
        if (cuenta != null) {
            System.out.println("Numero: " + cuenta.getNumeroCuenta());
            System.out.println("Saldo: " + cuenta.getSaldo());
        } else {
            System.out.println("Cuenta no encontrada");
        }
    }

    public void listarCuentas() {
        for (Cuenta c : cuentaRepo.listarCuentas()) {
            System.out.println("Numero de cuenta: " + c.getNumeroCuenta() + ", Saldo: " + c.getSaldo());
        }
    }
}