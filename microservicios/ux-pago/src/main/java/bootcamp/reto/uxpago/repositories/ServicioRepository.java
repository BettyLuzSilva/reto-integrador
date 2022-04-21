package bootcamp.reto.uxpago.repositories;

import bootcamp.reto.uxpago.models.Servicio;
import reactor.core.publisher.Flux;

public interface ServicioRepository {
    Flux<Servicio> findBycanalPermitido(String canalPermitido, String token);

}
