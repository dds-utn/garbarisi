package ar.utn.ba.ddsi.garbarisi.models.entities.impuestos;

import ar.utn.ba.ddsi.garbarisi.models.entities.productos.Producto;
import lombok.Setter;

public class EI implements Impuesto {
	@Setter
	private static Double gananciasImpositivas;

	@Setter
	private static Double factorPrecioBase;

	@Setter
	private static Double factorGananciasImpositivas;

	public Double calculate(Producto producto){
		return ((producto.getPrecioBase()/factorPrecioBase) + (factorGananciasImpositivas * gananciasImpositivas));
	}
}