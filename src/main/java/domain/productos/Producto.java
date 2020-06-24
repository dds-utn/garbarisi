package domain.productos;

public class Producto {
	private TipoProducto tipo;
	private Double precioBase;
	private String descripcion;

	public Producto(String descripcion, Double precioBase, TipoProducto tipoProducto) {
		super();
		this.tipo = tipoProducto;
		this.precioBase = precioBase;
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public TipoProducto getTipo() {
		return tipo;
	}

	public Double getPrecioBase() {
		return precioBase;
	}
	
	public  Double precioFinal(){
		return  this.totalImpuestos() + this.getPrecioBase();
	}
	
	public Double totalImpuestos(){
		return this.tipo.totalImpuestos(this);
	}
}