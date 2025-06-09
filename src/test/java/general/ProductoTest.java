package general;

import ar.utn.ba.ddsi.garbarisi.models.entities.Sucursal;
import ar.utn.ba.ddsi.garbarisi.models.entities.impuestos.EI;
import ar.utn.ba.ddsi.garbarisi.models.entities.impuestos.EO;
import ar.utn.ba.ddsi.garbarisi.models.entities.impuestos.IVA;
import ar.utn.ba.ddsi.garbarisi.models.entities.observers.ContadorDeVentas;
import ar.utn.ba.ddsi.garbarisi.models.entities.observers.Deposito;
import ar.utn.ba.ddsi.garbarisi.models.entities.observers.OficinaContable;
import ar.utn.ba.ddsi.garbarisi.models.entities.observers.adapters.AdapterSistemaContable;
import ar.utn.ba.ddsi.garbarisi.models.entities.productos.Producto;
import ar.utn.ba.ddsi.garbarisi.models.entities.productos.TipoProducto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ProductoTest {
	private Sucursal sucursal;
	private ContadorDeVentas contador;
	private Deposito deposito;
	private OficinaContable oficinaContable;
	private TipoProducto electronico;
	private TipoProducto hogar;
	private Producto celu;
	private Producto estufa;
	private AdapterSistemaContable adapterSistemaContable;

	@BeforeEach
	public void init(){
		EI.setGananciasImpositivas(3.50);
		EI.setFactorPrecioBase(4.0);
		EI.setFactorGananciasImpositivas(0.3);

		EO.setGananciasImpositivas(4.0);
		EO.setFactorPrecioBase(0.5);
		EO.setFactorGananciasImpositivas(4.0);

		IVA.setPorcentaje(0.21);

		electronico = new TipoProducto();
		electronico.agregarImpuestos(new EO(), new IVA());

		hogar = new TipoProducto();
		hogar.agregarImpuestos(new EI(), new IVA());

		this.adapterSistemaContable = Mockito.mock(AdapterSistemaContable.class);
		this.contador = new ContadorDeVentas();
		this.oficinaContable = new OficinaContable(adapterSistemaContable);
		this.deposito = new Deposito();
		this.celu = new Producto(electronico,  120000.00, "Samsumng S20 PRO");
		this.estufa = new Producto(hogar, 15000.00, "Estufa tiro balanceado Orbis");

		this.sucursal = new Sucursal("Casa Central");
		this.sucursal.agregarProductos(this.celu, this.estufa);

		this.sucursal.agregarObservers(deposito, oficinaContable, contador);
	}

	@Test
	public void oficinaContableSeEnteraDeLaVentaDelCelu(){
		this.sucursal.vende(this.celu);
		Assertions.assertTrue(this.oficinaContable.getTotalLibroDiario() > this.celu.getPrecioBase());
		Mockito.verify(adapterSistemaContable).notificar(this.celu);
	}

	@Test
	public void contadorDeVentasSeEnteraDeLaVentaDelCelu(){
		this.sucursal.vende(this.celu);
		Assertions.assertEquals(1, this.contador.getCantidadVentas());
	}

	@Test
	public void depositoPreparaCelu(){
		this.sucursal.vende(this.celu);
		Assertions.assertTrue(this.deposito.getProductosAPreparar().contains(this.celu));
	}
}
