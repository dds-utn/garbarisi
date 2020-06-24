package domain.observers;

import domain.productos.Producto;

public class ContadorDeVentas implements IObserver {
	private int cantidadVentas;
	
	public int getCantidadVentas() {
		return cantidadVentas;
	}

	public ContadorDeVentas(){
		this.cantidadVentas = 0;
	}

	public void notificarVenta(Producto producto){
		this.cantidadVentas += 1;
	}
}