package ar.utn.ba.ddsi.garbarisi.models.entities.observers;

import ar.utn.ba.ddsi.garbarisi.models.entities.observers.adapters.AdapterSistemaContable;
import ar.utn.ba.ddsi.garbarisi.models.entities.productos.Producto;
import lombok.Getter;

@Getter
public class OficinaContable implements IObserver {
	private Double totalLibroDiario;
	private AdapterSistemaContable adapter;

	public OficinaContable(AdapterSistemaContable adapter) {
		this.totalLibroDiario = 0.0;
		this.adapter = adapter;
	}

	public void notificarVenta(Producto producto) {
		this.totalLibroDiario += producto.precioFinal();
		adapter.notificar(producto);
	}
}