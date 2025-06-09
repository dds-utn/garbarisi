package ar.utn.ba.ddsi.garbarisi.models.entities.productos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
	private TipoProducto tipo;
	private Double precioBase;
	private String descripcion;

	public  Double precioFinal(){
		return  this.totalImpuestos() + this.getPrecioBase();
	}
	
	public Double totalImpuestos(){
		return this.tipo.totalImpuestos(this);
	}
}