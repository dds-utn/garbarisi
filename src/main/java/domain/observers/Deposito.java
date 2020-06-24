package domain.observers;

import domain.productos.Producto;
import java.util.ArrayList;
import java.util.List;

public class Deposito implements IObserver {
	private List<Producto> productosAPreparar;
	
	public Deposito(){
		this.productosAPreparar = new ArrayList<>();
	}

	public List<Producto> getProductosAPreparar() {
		return productosAPreparar;
	}

	public void notificarVenta(Producto producto){
		this.preparar(producto);
	}
	
	private void preparar(Producto producto){
		this.productosAPreparar.add(producto);
	}
}