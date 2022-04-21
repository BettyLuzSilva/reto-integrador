package bootcamp.reto.pagoservicios.repositories;

import bootcamp.reto.pagoservicios.models.Servicio;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ServicioRepository extends ReactiveMongoRepository<Servicio, String> {
    Flux<Servicio> findBycanalPermitido(String canalPermitido);

}
