package bootcamp.reto.uxpago.repositories.impl;

import bootcamp.reto.uxpago.core.exception.TransaccionException;
import bootcamp.reto.uxpago.models.Transaccion;
import bootcamp.reto.uxpago.repositories.TransaccionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;
import reactor.util.retry.Retry;

import java.time.Duration;

@Slf4j
@Repository
public class TransaccionRepositoryImpl  implements TransaccionRepository {

    private final WebClient clientTran;

    public TransaccionRepositoryImpl(WebClient.Builder builder,
                                     @Value( "${application.urlApiTrans:http://localhost:8083/pagos}" ) String urlApiTrans) {
        log.info("url de la api de pagos = " + urlApiTrans);

        HttpClient client = HttpClient.create()
                .responseTimeout(Duration.ofSeconds(2));
        this.clientTran = builder
                .baseUrl(urlApiTrans)
                .clientConnector(new ReactorClientHttpConnector(client))
                .build();
    }

    @Override
    public Mono<Transaccion> save(Transaccion transaccion, String token) {
// Aqui se puede obtener los headers
                return this.clientTran.post()
                        .uri("")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization","Bearer "+ token)
                        .bodyValue(transaccion)
                        .retrieve()
                        .onStatus(HttpStatus::is5xxServerError, response-> Mono.error(new TransaccionException("Server error")))
                        .bodyToMono(Transaccion.class)
                        .retryWhen(
                                Retry.fixedDelay(2, Duration.ofSeconds(2))
                                        .doBeforeRetry(x->  log.info("Log  -  antes del  retry " + x))
                        )
                        .doOnError(x-> log.info("log - error"));

    }
}
