package com.mycompany.banco.Aplicacion;
import com.mycompany.banco.Dominio.Cliente;
import java.util.List;
import java.util.ArrayList;
import com.mycompany.banco.Dominio.Cuenta;
public class CuentaService {
private List<Cuenta> cuentas = new ArrayList<>();
private List<Cliente> clientes = new ArrayList<>();
public boolean agregarCuenta(Cuenta cuenta){
    if(buscarCuenta(cuenta.getNumeroCuenta()) != null){
        System.out.println("Error: Ya existe una cuenta con ese número.");
        return false;
    }
    cuentas.add(cuenta);
    return true;
}
public Cuenta buscarCuenta(long numero){
    for(Cuenta c : cuentas){
        if(c.getNumeroCuenta() == numero){
            return c;
        }
    }
    return null;
}
public void depositar(long numeroCuenta, double monto){
    Cuenta cuenta = buscarCuenta(numeroCuenta);
    
    if(cuenta != null){
        cuenta.depositar(monto);
    }else{
        System.out.println("Cuenta no encontrada");
    }
}
public void retirar(long numeroCuenta, double monto){
    Cuenta cuenta = buscarCuenta(numeroCuenta);
    
    if(cuenta != null){
        boolean resultado = cuenta.retirar(monto);
        
        if(!resultado){
            System.out.println("Fondos insuficientes o monto inválido");
        }
    }else{
        System.out.println("Cuenta no encontrada");
    }
}
public void mostrarCuenta(long numeroCuenta){
    Cuenta cuenta = buscarCuenta(numeroCuenta);

    if(cuenta != null){
        System.out.println("Numero: " + cuenta.getNumeroCuenta());
        System.out.println("Saldo: " + cuenta.getSaldo());
    }else{
        System.out.println("Cuenta no encontrada");
    }
}
public void listarCuentas() {
    if (cuentas.isEmpty()) {
        System.out.println("No hay cuentas registradas.");
        return;
    }

    for (Cuenta c : cuentas) {
        System.out.println("Numero de cuenta: " + c.getNumeroCuenta() + ", Saldo: " + c.getSaldo());
    }
}

public void crearCuentaParaCliente(long idCliente, Cuenta cuenta){
    Cliente cliente = buscarCliente(idCliente);

    if(cliente != null){
        cliente.agregarCuenta(cuenta);
    }else{
        System.out.println("Cliente no encontrado");
    }
}
public Cliente buscarCliente(long id){
    for(Cliente c : clientes){
        if(c.getId() == id){
            return c;
        }
    }
    return null;
}
public void mostrarCuentasDeCliente(long idCliente){
    Cliente cliente = buscarCliente(idCliente);

    if(cliente != null){
        for(Cuenta c : cliente.getCuentas()){
            System.out.println("Numero: " + c.getNumeroCuenta());
            System.out.println("Saldo: " + c.getSaldo());
        }
    }else{
        System.out.println("Cliente no encontrado");
    }
}
public void agregarCliente(Cliente cliente){
    clientes.add(cliente);
}
public boolean actualizarCuenta(long NumeroCuenta, Cuenta nuevaCuenta) {
    for (int i = 0; i < cuentas.size(); i++) {
        if (cuentas.get(i).getNumeroCuenta() ==NumeroCuenta ) {
            cuentas.set(i, nuevaCuenta); // Reemplaza la cuenta existente
            return true; // Éxito
        }
    }
    return false; // No se encontró la cuenta
}
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

    boolean eliminadoGlobal = false;
    for (int i = 0; i < cuentas.size(); i++) {
        if (cuentas.get(i).getNumeroCuenta() == numeroCuenta) {
            cuentas.remove(i);
            eliminadoGlobal = true;
            break;
        }
    }

    if (eliminadoGlobal) {
        System.out.println("Cuenta " + numeroCuenta + " eliminada del cliente " + idCliente + " y de la lista global");
    } else {
        System.out.println("Error: La cuenta existía en el cliente pero no en la lista global");
    }

    return eliminadoGlobal;
}
}
