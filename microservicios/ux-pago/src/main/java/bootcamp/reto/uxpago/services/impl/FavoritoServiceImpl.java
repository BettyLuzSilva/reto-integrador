package bootcamp.reto.uxpago.services.impl;

import bootcamp.reto.uxpago.models.Favorito;
import bootcamp.reto.uxpago.repositories.FavoritoRepository;
import bootcamp.reto.uxpago.services.FavoritoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@Service
public class FavoritoServiceImpl  implements FavoritoService {

    @Autowired
    private FavoritoRepository favoritoRepository;
    @Override
    public Mono<Favorito> save(Favorito favorito, String token) {
        return favoritoRepository
                        .save(favorito, token);

    }
}
