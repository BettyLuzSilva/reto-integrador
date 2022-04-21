package bootcamp.reto.favoritos.favoritos.repositories;

import bootcamp.reto.favoritos.favoritos.models.Favorito;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface FavoritoRepository extends ReactiveCrudRepository<Favorito, Integer> {
}
