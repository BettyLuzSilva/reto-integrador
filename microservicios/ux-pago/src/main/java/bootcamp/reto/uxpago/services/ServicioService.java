package bootcamp.reto.uxpago.services;

import bootcamp.reto.uxpago.models.Servicio;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ServicioService {

    Flux<Servicio> findBycanalPermitido(String canalPermitido, String token);
}
