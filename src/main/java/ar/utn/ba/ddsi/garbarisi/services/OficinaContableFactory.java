package ar.utn.ba.ddsi.garbarisi.services;

import ar.utn.ba.ddsi.garbarisi.models.entities.observers.OficinaContable;
import ar.utn.ba.ddsi.garbarisi.models.entities.observers.adapters.AdapterSistemaContable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OficinaContableFactory {
    private final AdapterSistemaContable adapterSistemaContable;

    @Autowired
    public OficinaContableFactory(AdapterSistemaContable adapterSistemaContable) {
        this.adapterSistemaContable = adapterSistemaContable;
    }

    public OficinaContable crear() {
        return new OficinaContable(adapterSistemaContable);
    }
} 