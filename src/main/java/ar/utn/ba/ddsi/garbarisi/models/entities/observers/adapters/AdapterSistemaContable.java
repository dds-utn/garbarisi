package ar.utn.ba.ddsi.garbarisi.models.entities.observers.adapters;

import ar.utn.ba.ddsi.garbarisi.models.entities.productos.Producto;

public interface AdapterSistemaContable {
    void notificar(Producto producto);
} 