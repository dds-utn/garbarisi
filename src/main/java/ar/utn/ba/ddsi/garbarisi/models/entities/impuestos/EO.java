package ar.utn.ba.ddsi.garbarisi.models.entities.impuestos;

import ar.utn.ba.ddsi.garbarisi.models.entities.productos.Producto;
import lombok.Setter;

public class EO implements Impuesto {
	@Setter
	private static Double gananciasImpositivas;

	@Setter
	private static Double factorPrecioBase;

	@Setter
	private static Double factorGananciasImpositivas;

	public Double calculate(Producto producto){
		return (factorPrecioBase*producto.getPrecioBase() / (factorGananciasImpositivas*gananciasImpositivas));
	}
}