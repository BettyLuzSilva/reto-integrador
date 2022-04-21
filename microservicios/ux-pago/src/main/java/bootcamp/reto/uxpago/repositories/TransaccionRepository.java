package bootcamp.reto.uxpago.repositories;

import bootcamp.reto.uxpago.models.Transaccion;
import reactor.core.publisher.Mono;

public interface TransaccionRepository {
    Mono<Transaccion> save(Transaccion transaccion, String token) ;
}
