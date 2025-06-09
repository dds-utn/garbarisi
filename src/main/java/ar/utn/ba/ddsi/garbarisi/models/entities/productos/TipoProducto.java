package ar.utn.ba.ddsi.garbarisi.models.entities.productos;

import ar.utn.ba.ddsi.garbarisi.models.entities.impuestos.Impuesto;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
public class TipoProducto {
    @Setter
    private String descripcion;
    private List<Impuesto> impuestos;

    public TipoProducto(){
        super();
        this.impuestos = new ArrayList<>();
    }

    public void agregarImpuestos(Impuesto ... impuestos){
        Collections.addAll(this.impuestos, impuestos);
    }

    public Double totalImpuestos(Producto producto){
        return this.impuestos.stream().mapToDouble(impuesto -> impuesto.calculate(producto)).sum();
    }
}
