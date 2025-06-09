package ar.utn.ba.ddsi.garbarisi.models.entities.observers.adapters;

import ar.utn.ba.ddsi.garbarisi.models.entities.productos.Producto;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class AdapterSistemaContableHttp implements ar.utn.ba.ddsi.garbarisi.models.entities.observers.adapters.AdapterSistemaContable {
    private final WebClient webClient;

    public AdapterSistemaContableHttp() {
        this.webClient = WebClient.create("http://sistema-contable/api");
    }

    @Override
    public void notificar(Producto producto) {
        webClient.post()
            .uri("/ventas")
            .bodyValue(producto)
            .retrieve()
            .bodyToMono(Void.class)
            .subscribe();
    }
} 