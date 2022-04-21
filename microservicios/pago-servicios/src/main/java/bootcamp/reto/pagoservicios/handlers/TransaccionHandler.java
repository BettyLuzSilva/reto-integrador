package bootcamp.reto.pagoservicios.handlers;

import bootcamp.reto.pagoservicios.models.Servicio;
import bootcamp.reto.pagoservicios.models.Transaccion;
import bootcamp.reto.pagoservicios.services.TransaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class TransaccionHandler {

    @Autowired
    private TransaccionService transaccionService;

    public Mono<ServerResponse> findAll(ServerRequest request) {
        return ok().contentType(APPLICATION_JSON)
                .body(transaccionService.findAll(), Transaccion.class);
    }

    public Mono<ServerResponse> save(ServerRequest request) {

        return request.bodyToMono(Transaccion.class)
                .flatMap(trans -> this.transaccionService.save(trans))
                .flatMap(trans -> ServerResponse.ok().body(Mono.just(trans), Transaccion.class));
    }
}
