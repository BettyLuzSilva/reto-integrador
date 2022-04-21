package bootcamp.reto.pagoservicios.repositories;

import bootcamp.reto.pagoservicios.models.Transaccion;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransaccionRepository extends ReactiveMongoRepository<Transaccion, String> {
}
