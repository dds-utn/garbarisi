package domain.impuestos;

import domain.productos.Producto;

public class EI implements Impuesto {
	private static Double gananciasImpositivas;
	private static Double factorPrecioBase;
	private static Double factorGananciasImpositivas;

	public static void setGananciasImpositivas(Double gananciasImpositivas) {
		EI.gananciasImpositivas = gananciasImpositivas;
	}

	public static void setFactorGananciasImpositivas(Double factorGananciasImpositivas) {
		EI.factorGananciasImpositivas = factorGananciasImpositivas;
	}

	public static void setFactorPrecioBase(Double factorPrecioBase) {
		EI.factorPrecioBase = factorPrecioBase;
	}

	public Double calculate(Producto producto){
		return ((producto.getPrecioBase()/factorPrecioBase) + (factorGananciasImpositivas * gananciasImpositivas));
	}
}