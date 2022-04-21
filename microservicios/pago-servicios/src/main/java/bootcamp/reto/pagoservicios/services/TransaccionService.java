package bootcamp.reto.pagoservicios.services;


import bootcamp.reto.pagoservicios.models.Transaccion;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TransaccionService {
    Flux<Transaccion> findAll();
    Mono<Transaccion> save(Transaccion transaccion);
}
