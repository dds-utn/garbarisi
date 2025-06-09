package ar.utn.ba.ddsi.garbarisi.models.entities;

import ar.utn.ba.ddsi.garbarisi.models.entities.observers.IObserver;
import ar.utn.ba.ddsi.garbarisi.models.entities.productos.Producto;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
public class Sucursal {
    private String nombre;
    private List<Producto> productos;
    private List<IObserver> observers;

    public Sucursal(String nombre) {
        this.nombre = nombre;
        this.productos = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    public void agregarObservers(IObserver... observers){
        Collections.addAll(this.observers, observers);
    }

    public void eliminarObserver(IObserver observer){
        this.observers.remove(observer);
    }

    public void agregarProductos(Producto ... productos){
        Collections.addAll(this.productos, productos);
    }

    public void vende(Producto producto){
        this.observers.forEach(o -> o.notificarVenta(producto));
    }
}