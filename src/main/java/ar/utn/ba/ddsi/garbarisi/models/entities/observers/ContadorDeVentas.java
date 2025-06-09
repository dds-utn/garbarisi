package ar.utn.ba.ddsi.garbarisi.models.entities.observers;

import ar.utn.ba.ddsi.garbarisi.models.entities.productos.Producto;
import lombok.Getter;

@Getter
public class ContadorDeVentas implements IObserver {
	private int cantidadVentas;

	public ContadorDeVentas(){
		this.cantidadVentas = 0;
	}

	public void notificarVenta(Producto producto){
		this.cantidadVentas += 1;
	}
}