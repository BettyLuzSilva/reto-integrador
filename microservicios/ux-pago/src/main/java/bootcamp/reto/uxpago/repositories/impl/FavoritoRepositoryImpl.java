package bootcamp.reto.uxpago.repositories.impl;

import bootcamp.reto.uxpago.core.exception.FavoritoException;
import bootcamp.reto.uxpago.core.exception.TransaccionException;
import bootcamp.reto.uxpago.models.Favorito;
import bootcamp.reto.uxpago.models.Transaccion;
import bootcamp.reto.uxpago.repositories.FavoritoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@Repository
public class FavoritoRepositoryImpl  implements FavoritoRepository {
    private final WebClient clientFavo;

    public FavoritoRepositoryImpl(WebClient.Builder builder,
                                     @Value( "${application.urlApiFavo:http://localhost:8081/favoritos}" ) String urlApiFavo) {
        log.info("url de la api de favoritos = " + urlApiFavo);

//          Modo normal sin control de tiempo limite de espera
        this.clientFavo = builder
                .baseUrl(urlApiFavo)
                .build();
    }

    @Override
    public Mono<Favorito> save(Favorito favorito,  String token) {
        return this.clientFavo.post()
                .uri("")
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization","Bearer "+token)
                .bodyValue(favorito)
                .retrieve()
                .onStatus(HttpStatus::is5xxServerError, response-> Mono.error(new FavoritoException("Server error")))
                .bodyToMono(Favorito.class);
    }
}
