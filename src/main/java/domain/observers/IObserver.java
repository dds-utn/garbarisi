package domain.observers;

import domain.productos.Producto;

public interface IObserver {
	public void notificarVenta(Producto producto);
}