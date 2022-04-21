package bootcamp.reto.pagoservicios.handlers;

import bootcamp.reto.pagoservicios.models.Servicio;
import bootcamp.reto.pagoservicios.services.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class ServicioHandler {

    @Autowired
    private ServicioService servicioService;

    public Mono<ServerResponse> findAll(ServerRequest request) {
        return ok().contentType(APPLICATION_JSON)
                .body(servicioService.findAll(), Servicio.class);
    }

    public Mono<ServerResponse> save(ServerRequest request) {

        return request.bodyToMono(Servicio.class)
                .flatMap(servicio -> this.servicioService.save(servicio))
                .flatMap(servicio -> ServerResponse.ok().body(Mono.just(servicio), Servicio.class));
    }

    public Mono<ServerResponse> findCanal(ServerRequest request){
        var canal = request.pathVariable("canal");
        return ServerResponse.ok()
                .contentType(APPLICATION_JSON)
                .body(servicioService.findBycanalPermitido(canal), Servicio.class);

    }
}
