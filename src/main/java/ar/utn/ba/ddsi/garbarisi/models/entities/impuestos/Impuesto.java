package ar.utn.ba.ddsi.garbarisi.models.entities.impuestos;

import ar.utn.ba.ddsi.garbarisi.models.entities.productos.Producto;

public interface Impuesto {
	public Double calculate(Producto producto);
}