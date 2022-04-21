package bootcamp.reto.pagoservicios.services.impl;

import bootcamp.reto.pagoservicios.models.Transaccion;
import bootcamp.reto.pagoservicios.repositories.TransaccionRepository;
import bootcamp.reto.pagoservicios.services.TransaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class TransaccionServiceImpl implements TransaccionService {

    @Autowired
    private TransaccionRepository transaccionRepository;

    @Override
    public Flux<Transaccion> findAll() {
        return transaccionRepository.findAll();
    }

    @Override
    public Mono<Transaccion> save(Transaccion transaccion) {

        return transaccionRepository.save(transaccion).delayElement(Duration.ofSeconds((int)(Math.random()*3))) ;
//        return transaccionRepository.save(transaccion)
    }

}
