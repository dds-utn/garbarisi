package ar.utn.ba.ddsi.garbarisi.models.entities.observers;

import ar.utn.ba.ddsi.garbarisi.models.entities.productos.Producto;

public interface IObserver {
	public void notificarVenta(Producto producto);
}