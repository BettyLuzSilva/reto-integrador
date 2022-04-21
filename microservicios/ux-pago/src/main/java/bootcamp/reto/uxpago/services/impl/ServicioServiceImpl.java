package bootcamp.reto.uxpago.services.impl;

import bootcamp.reto.uxpago.core.exception.ServicioException;
import bootcamp.reto.uxpago.models.Servicio;
import bootcamp.reto.uxpago.repositories.ServicioRepository;
import bootcamp.reto.uxpago.services.ServicioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class ServicioServiceImpl  implements ServicioService {

    @Autowired
    private ServicioRepository servicioRepository;

    @Override
    public Flux<Servicio> findBycanalPermitido(String canalPermitido, String token) {

        return servicioRepository
                .findBycanalPermitido(canalPermitido, token);
//                .onErrorResume(e -> Mono.empty())
//              .switchIfEmpty(Mono.error(new ServicioException("Canal  no encontrado")));
//               .collectList()
//              .flatMap(  serv -> return  body(Flux.just(serv), Servicio.class));
    }


}
