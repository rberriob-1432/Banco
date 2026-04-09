package com.mycompany.banco.Dominio;

public abstract class Cuenta {
    private long numeroCuenta;
    private double saldo;

    public Cuenta(long numeroCuenta, double saldo){
       this.numeroCuenta = numeroCuenta;
       this.saldo = saldo;
    }

    public long getNumeroCuenta() { return numeroCuenta; }
    public double getSaldo() { return saldo; }
    public void setSaldo(double saldo) { this.saldo = saldo; }

    public void depositar(double monto) {
        if (monto <= 0) return;
        this.saldo += monto;
    }

    public boolean retirar(double monto) {
        if (monto <= 0 || monto > this.saldo) return false;
        this.saldo -= monto;
        return true;
    }
}