package bootcamp.reto.uxpago.handlers;

import bootcamp.reto.uxpago.models.Transaccion;
import bootcamp.reto.uxpago.services.TransaccionService;
import io.lettuce.core.dynamic.annotation.CommandNaming;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class TransaccionHandler {

    @Autowired
    private TransaccionService transaccionService;

    public Mono<ServerResponse> save(ServerRequest request) {
        var opcFavorito=request.queryParam("favorito").get();
        var tokenHeader =request.headers().header("Authorization");
        String token =  tokenHeader.get(0);

        log.info("tokenHeader =" + tokenHeader);
        return request.bodyToMono(Transaccion.class)
                .flatMap(trans -> this.transaccionService.save(trans, opcFavorito, token))
                .flatMap(trans -> ServerResponse.ok().body(Mono.just(trans), Transaccion.class));
    }
}
