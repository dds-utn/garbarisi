package ar.utn.ba.ddsi.garbarisi.services;

import ar.utn.ba.ddsi.garbarisi.models.entities.Sucursal;
import ar.utn.ba.ddsi.garbarisi.models.entities.observers.ContadorDeVentas;
import ar.utn.ba.ddsi.garbarisi.models.entities.observers.Deposito;
import ar.utn.ba.ddsi.garbarisi.models.entities.observers.OficinaContable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SucursalService {
    private final OficinaContableFactory oficinaContableFactory;

    @Autowired
    public SucursalService(OficinaContableFactory oficinaContableFactory) {
        this.oficinaContableFactory = oficinaContableFactory;
    }

    public Sucursal crearSucursal(String nombre) {
        Sucursal sucursal = new Sucursal(nombre);
        OficinaContable oficinaContable = oficinaContableFactory.crear();
        Deposito deposito = new Deposito();
        ContadorDeVentas contadorDeVentas = new ContadorDeVentas();
        sucursal.agregarObservers(oficinaContable, deposito, contadorDeVentas);
        return sucursal;
    }
} 