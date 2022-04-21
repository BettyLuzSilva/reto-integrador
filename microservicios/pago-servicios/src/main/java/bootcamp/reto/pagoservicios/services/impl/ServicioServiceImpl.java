package bootcamp.reto.pagoservicios.services.impl;

import bootcamp.reto.pagoservicios.models.Servicio;
import bootcamp.reto.pagoservicios.repositories.ServicioRepository;
import bootcamp.reto.pagoservicios.services.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ServicioServiceImpl implements ServicioService {

    @Autowired
    private ServicioRepository servicioRepository;

    @Override
    public Flux<Servicio> findAll() {
        return servicioRepository.findAll();
    }

    @Override
    public Flux<Servicio> findBycanalPermitido( String canalPermitido ) {
        return servicioRepository.findBycanalPermitido( canalPermitido );
//        return servicioRepository
//                .findBycanalPermitido( canalPermitido)
//                .delayElements(Duration.ofSeconds((int)(Math.random()*5)));
    }

    @Override
    public Mono<Servicio> save(Servicio servicio) {
        return servicioRepository.save(servicio);
    }
}
