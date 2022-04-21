package bootcamp.reto.uxpago.services;

import bootcamp.reto.uxpago.models.Transaccion;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TransaccionService {
    Flux<Transaccion> findAll();
    Mono<Transaccion> save(Transaccion transaccion, String favorito, String token);
}
