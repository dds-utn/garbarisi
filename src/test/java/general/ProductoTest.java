package general;

import domain.Sucursal;
import domain.impuestos.EI;
import domain.impuestos.EO;
import domain.impuestos.IVA;
import domain.observers.ContadorDeVentas;
import domain.observers.Deposito;
import domain.observers.OficinaContable;
import domain.productos.Producto;
import domain.productos.TipoProducto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ProductoTest {
	private Sucursal sucursal;
	private ContadorDeVentas contador;
	private Deposito deposito;
	private OficinaContable oficinaContable;
	private TipoProducto electronico;
	private TipoProducto hogar;
	private Producto celu;
	private Producto estufa;

	@Before
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

		this.contador = new ContadorDeVentas();
		this.oficinaContable = new OficinaContable();
		this.deposito = new Deposito();
		this.celu = new Producto("Samsumng S20 PRO", 120000.00, electronico);
		this.estufa = new Producto("Estufa tiro balanceado Orbis", 15000.00, hogar);

		this.sucursal = new Sucursal("Casa Central");
		this.sucursal.agregarProductos(this.celu, this.estufa);

		this.deposito = new Deposito();
		this.oficinaContable = new OficinaContable();
		this.contador = new ContadorDeVentas();

		this.sucursal.agregarObservers(deposito, oficinaContable, contador);
	}

	@Test
	public void oficinaContableSeEnteraDeLaVentaDelCelu(){
		this.sucursal.vende(this.celu);
		Assert.assertTrue(this.oficinaContable.getLibroDiario() > this.celu.getPrecioBase());
	}

	@Test
	public void contadorDeVentasSeEnteraDeLaVentaDelCelu(){
		this.sucursal.vende(this.celu);
		Assert.assertEquals(1, this.contador.getCantidadVentas());
	}

	@Test
	public void depositoPreparaCelu(){
		this.sucursal.vende(this.celu);
		Assert.assertTrue(this.deposito.getProductosAPreparar().contains(this.celu));
	}
}
