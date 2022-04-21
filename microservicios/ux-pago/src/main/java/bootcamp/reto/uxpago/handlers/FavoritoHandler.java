package bootcamp.reto.uxpago.handlers;

import bootcamp.reto.uxpago.models.Favorito;
import bootcamp.reto.uxpago.models.Servicio;
import bootcamp.reto.uxpago.services.FavoritoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class FavoritoHandler {

    @Autowired
    private FavoritoService favoritoService;

    public Mono<ServerResponse> save(ServerRequest request) {
        var tokenHeader =request.headers().header("Authorization");
        String token =  tokenHeader.get(0);

         log.info("tokenHeader =" + tokenHeader);

        return request.bodyToMono(Favorito.class)
                .flatMap(favo -> this.favoritoService.save(favo, token))
                .flatMap(favo -> ServerResponse.ok().body(Mono.just(favo), Favorito.class));
    }
}
