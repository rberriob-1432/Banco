package com.mycompany.banco.Dominio;
import com.mycompany.banco.aplicacion.AgregableCuenta;
import java.util.List;
import java.util.ArrayList;
public abstract class Cliente implements AgregableCuenta {
    private String nombre;
    private long id;
private List<Cuenta> cuentas = new ArrayList<>(); 
    public  Cliente(String nombre, long id){
    this.nombre=nombre; 
    this.id=id;
    this.cuentas=new ArrayList<>();
    }
    public String getNombre(){
        return nombre;
    }
    public long getId(){
        return id;
    }
    public List<Cuenta> getCuentas(){
        return cuentas;
    }
    @Override
    public  void agregarCuenta (Cuenta cuenta){
        cuentas.add(cuenta);
    }
}
