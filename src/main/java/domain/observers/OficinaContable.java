package domain.observers;

import domain.productos.Producto;

public class OficinaContable implements IObserver {
	private Double totalLibroDiario;
	
	public Double getLibroDiario() {
		return totalLibroDiario;
	}

	public OficinaContable(){
		this.totalLibroDiario = 0.0;
	}

	public void notificarVenta(Producto producto){
		this.totalLibroDiario += producto.precioFinal();
	}
}