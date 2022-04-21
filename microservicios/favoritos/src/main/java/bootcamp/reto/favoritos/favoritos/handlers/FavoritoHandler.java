package bootcamp.reto.favoritos.favoritos.handlers;

import bootcamp.reto.favoritos.favoritos.models.Favorito;
import bootcamp.reto.favoritos.favoritos.services.FavoritoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Slf4j
@Component
public class FavoritoHandler {

    @Autowired
    private FavoritoService favoritoService;

    public Mono<ServerResponse> findAll(ServerRequest request) {
        return ok().contentType(APPLICATION_JSON)
                .body(favoritoService.findAll(), Favorito.class);
    }

    public Mono<ServerResponse> save(ServerRequest request) {
            var tokenHeader =request.headers().header("Authorization");
            String token =  tokenHeader.get(0);
            log.info("token solo  =" + token);
        return request.bodyToMono(Favorito.class)
                .flatMap(favorito -> this.favoritoService.save(favorito))
                .flatMap(favorito -> ServerResponse.ok().body(Mono.just(favorito), Favorito.class));
    }

}
