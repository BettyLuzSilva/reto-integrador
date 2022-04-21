package bootcamp.reto.pagoservicios.services;

import bootcamp.reto.pagoservicios.models.Servicio;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface ServicioService {
    Flux<Servicio> findAll();
    Flux<Servicio> findBycanalPermitido( String canalPermitido);
    Mono<Servicio> save(Servicio servicio);


}
