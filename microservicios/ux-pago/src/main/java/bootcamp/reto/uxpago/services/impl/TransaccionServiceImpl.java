package bootcamp.reto.uxpago.services.impl;

import bootcamp.reto.uxpago.core.exception.ServicioException;
import bootcamp.reto.uxpago.core.exception.TransaccionException;
import bootcamp.reto.uxpago.models.Favorito;
import bootcamp.reto.uxpago.models.Transaccion;
import bootcamp.reto.uxpago.repositories.FavoritoRepository;
import bootcamp.reto.uxpago.repositories.ServicioRepository;
import bootcamp.reto.uxpago.repositories.TransaccionRepository;
import bootcamp.reto.uxpago.services.FavoritoService;
import bootcamp.reto.uxpago.services.TransaccionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class TransaccionServiceImpl  implements TransaccionService {

    @Autowired
    private ServicioRepository servicioRepository;

    @Autowired
    private TransaccionRepository transaccionRepository;

    @Autowired
    private FavoritoRepository favoritoRepository;

    @Autowired
    private FavoritoService favoritoService;

    @Override
    public Flux<Transaccion> findAll() {
        return null;
    }

    @Override
    public Mono<Transaccion> save(Transaccion transaccion, String favorito, String token) {
        //  Validar que el codigo de servicio exista (previo al cache)

//        var canalPermitido = transaccion.getCanalPago();
//
//        servicioRepository
//               .findBycanalPermitido(canalPermitido, token)
//               .switchIfEmpty(Mono.error(new ServicioException ("Canal  no encontrado")))
//               .flatMap(servicio -> {
//
//                   if ( servicio.getCodServicio() == transaccion.getCodServicio() ) {
//                          Mono.error(new ServicioException("Codigo de servicio permitido"));
//                   } else {
//                          Mono.error(new ServicioException("Codigo de servicio no permitido"));
//                       }
//               });
//

        Favorito favoritoTrans  = new Favorito();

        if ( favorito.toUpperCase().equals( "S" ) ) {
            //  Se prepara  los datos a  grabar en favorito
            favoritoTrans.setTipoFavorito(transaccion.getTipoFavorito());
            favoritoTrans.setNombreFavorito(transaccion.getNombreFavorito());
            favoritoTrans.setCodServicio(transaccion.getCodServicio());
            favoritoTrans.setIdCliente(transaccion.getIdCliente());

//            favoritoService. save(favoritoTrans, token);

            return transaccionRepository
                    .save(transaccion, token)
                    .doOnSuccess( t -> {
                         favoritoService.
                                save(favoritoTrans, token).subscribe();
                               log.info("exito en transaccion" );
                    });
        } else {
            return transaccionRepository
                    .save(transaccion, token);
        }

//                .onErrorResume(e -> Mono.empty())
 //               .switchIfEmpty(Mono.error(new TransaccionException(HttpStatus.NOT_FOUND,"PagoTrans no encontrado")));
    }
}
