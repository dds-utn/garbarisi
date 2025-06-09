package ar.utn.ba.ddsi.garbarisi.models.entities.observers;

import ar.utn.ba.ddsi.garbarisi.models.entities.productos.Producto;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Deposito implements IObserver {
	private List<Producto> productosAPreparar;
	
	public Deposito(){
		this.productosAPreparar = new ArrayList<>();
	}

	public void notificarVenta(Producto producto){
		this.preparar(producto);
	}
	
	private void preparar(Producto producto){
		this.productosAPreparar.add(producto);
	}
}