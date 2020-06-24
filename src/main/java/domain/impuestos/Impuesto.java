package domain.impuestos;

import domain.productos.Producto;

public interface Impuesto {
	public Double calculate(Producto producto);
}