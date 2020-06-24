package domain.impuestos;

import domain.productos.Producto;

public class EO implements Impuesto {
	private static Double gananciasImpositivas;
	private static Double factorPrecioBase;
	private static Double factorGananciasImpositivas;

	public static void setGananciasImpositivas(Double gananciasImpositivas) {
		EO.gananciasImpositivas = gananciasImpositivas;
	}

	public static void setFactorPrecioBase(Double factorPrecioBase) {
		EO.factorPrecioBase = factorPrecioBase;
	}

	public static void setFactorGananciasImpositivas(Double factorGananciasImpositivas) {
		EO.factorGananciasImpositivas = factorGananciasImpositivas;
	}

	public Double calculate(Producto producto){
		return (factorPrecioBase*producto.getPrecioBase() / (factorGananciasImpositivas*gananciasImpositivas));
	}
}