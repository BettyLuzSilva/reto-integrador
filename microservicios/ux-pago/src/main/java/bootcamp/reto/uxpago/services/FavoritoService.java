package bootcamp.reto.uxpago.services;

import bootcamp.reto.uxpago.models.Favorito;
import bootcamp.reto.uxpago.models.Transaccion;
import reactor.core.publisher.Mono;

import java.util.List;

public interface FavoritoService {
    Mono<Favorito> save(Favorito favorito, String token);
}
