package ar.utn.ba.ddsi.garbarisi.models.entities.impuestos;

import ar.utn.ba.ddsi.garbarisi.models.entities.productos.Producto;
import lombok.Setter;

public class IVA implements Impuesto {
	@Setter
	private static Double porcentaje;

	public static Double getPorcentaje(){
		return IVA.porcentaje;
	}
	
	public Double calculate(Producto producto){
		return (IVA.getPorcentaje()*producto.getPrecioBase());
	}
}