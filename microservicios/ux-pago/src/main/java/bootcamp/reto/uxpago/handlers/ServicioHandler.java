package bootcamp.reto.uxpago.handlers;

import bootcamp.reto.uxpago.models.Servicio;
import bootcamp.reto.uxpago.services.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Component
public class ServicioHandler {

    @Autowired
    private ServicioService servicioService;

    public Mono<ServerResponse> findCanal(ServerRequest request){

        var tokenHeader =request.headers().header("Authorization");
        String token =  tokenHeader.get(0);

        var canal = request.pathVariable("canal");
        return ServerResponse.ok()
                .contentType(APPLICATION_JSON)
                 .body(servicioService.findBycanalPermitido(canal, token), Servicio.class);

    }

}
