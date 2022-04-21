package bootcamp.reto.favoritos.favoritos.services.impl;

import bootcamp.reto.favoritos.favoritos.models.Favorito;
import bootcamp.reto.favoritos.favoritos.repositories.FavoritoRepository;
import bootcamp.reto.favoritos.favoritos.services.FavoritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class FavoritoServiceImpl implements FavoritoService {

    @Autowired
    private FavoritoRepository favoritoRepository;

    @Override
    public Flux<Favorito> findAll() {
        return favoritoRepository.findAll();
    }

    @Override
    public Mono<Favorito> save(Favorito favorito) {
        return favoritoRepository.save(favorito);
    }
}
