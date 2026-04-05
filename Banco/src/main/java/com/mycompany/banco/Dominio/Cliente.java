package com.mycompany.banco.Dominio;
public class Cliente {
    private String nombre;
    private long id;
    public  Cliente(String nombre, long id){
    this.nombre=nombre; 
    this.id=id;
    }
    public String getNombre(){
        return nombre;
    }
    public long getId(){
        return id;
    }
}
