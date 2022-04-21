package bootcamp.reto.favoritos.favoritos.services;

import bootcamp.reto.favoritos.favoritos.models.Favorito;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FavoritoService {
    Flux<Favorito> findAll();
    Mono<Favorito> save(Favorito favorito);
}
