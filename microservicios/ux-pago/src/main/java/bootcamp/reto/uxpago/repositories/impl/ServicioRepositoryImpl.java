package bootcamp.reto.uxpago.repositories.impl;

import bootcamp.reto.uxpago.core.exception.ServicioException;
import bootcamp.reto.uxpago.models.Servicio;
import bootcamp.reto.uxpago.repositories.ServicioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;
import reactor.util.retry.Retry;

import java.time.Duration;

@Slf4j
@Repository
public class ServicioRepositoryImpl implements ServicioRepository {

    private final WebClient clientServ;

    public ServicioRepositoryImpl(WebClient.Builder builder,
                              @Value( "${application.urlApiServicio:http://localhost:8083/servicios}" ) String urlApiServicio) {
        log.info("url donde esta servicio de pagos = " + urlApiServicio);
        this.clientServ= builder
                .baseUrl(urlApiServicio)
                .build();


//  Configurar response timeout en  2 segundo ofSeconds si no hay respuesta valida da error,
//        HttpClient client = HttpClient.create()
//                .responseTimeout(Duration.ofSeconds(2));
//        this.clientServ = builder
//                .baseUrl(urlApiServicio)
//                .clientConnector(new ReactorClientHttpConnector(client))
//                .build();
   }

    @Override
    public Flux<Servicio> findBycanalPermitido(String canalPermitido, String token) {
//        return this.clientServ.get().uri("/canal/{canal}", canalPermitido).accept(MediaType.APPLICATION_JSON)
//                .retrieve()
//                .bodyToFlux(Servicio.class);

         return this.clientServ.get().uri("/canal/{canal}", canalPermitido).accept(MediaType.APPLICATION_JSON)
                 .header("Authorization","Bearer "+token)
                 .retrieve()
                .onStatus(HttpStatus::is5xxServerError, response-> Mono.error(new ServicioException("Server error")))
                .bodyToFlux(Servicio.class)
                .retryWhen(
                        Retry.fixedDelay(2, Duration.ofSeconds(2))
                        .doBeforeRetry(x->  log.info("LOG BEFORE RETRY=" + x))
                )
                .doOnError(x-> log.info("LOG ERROR"));



    }
}
