package com.mycompany.banco.Dominio;
public class Cuenta {
private long numeroCuenta;
private  double saldo;
public  Cuenta(long numeroCuenta, double saldo){
   this.numeroCuenta=numeroCuenta;
   this.saldo=saldo;
}
public long getNumeroCuenta(){
      return numeroCuenta;
}
public double getSaldo(){
    return saldo;
}
 public void depositar(double monto){
     if(monto<=0){
         return;
     }
        saldo += monto;
    }

    public boolean retirar(double monto){
    if(monto <= 0 || monto > saldo){
        return false;
    }
    saldo -= monto;
    return true;
}
}
