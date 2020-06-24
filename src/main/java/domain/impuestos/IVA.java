package domain.impuestos;

import domain.productos.Producto;

public class IVA implements Impuesto {
	private static Double porcentaje;
	
	public static void setPorcentaje(Double tasa){
		porcentaje = tasa;
	}
	
	public static Double getPorcentaje(){
		return IVA.porcentaje;
	}
	
	public Double calculate(Producto producto){
		return (IVA.getPorcentaje()*producto.getPrecioBase());
	}
}