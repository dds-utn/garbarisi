package domain.productos;

import domain.impuestos.Impuesto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TipoProducto {
    private String descripcion;
    private List<Impuesto> impuestos;

    public TipoProducto(){
        super();
        this.impuestos = new ArrayList<>();
    }

    public List<Impuesto> getImpuestos() {
        return impuestos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void agregarImpuestos(Impuesto ... impuestos){
        Collections.addAll(this.impuestos, impuestos);
    }

    public Double totalImpuestos(Producto producto){
        return this.impuestos.stream().mapToDouble(impuesto -> impuesto.calculate(producto)).sum();
    }
}
