package bootcamp.reto.uxpago.routes;

import bootcamp.reto.uxpago.handlers.FavoritoHandler;
import bootcamp.reto.uxpago.handlers.ServicioHandler;
import bootcamp.reto.uxpago.handlers.TransaccionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;

@Configuration
public class RouterConfiguration {

    @Bean
    public RouterFunction<ServerResponse> servicioRoutes(ServicioHandler servicioHandler) {
        return RouterFunctions.nest(RequestPredicates.path("/service"),
                RouterFunctions
                        .route(GET("/{canal}"), servicioHandler::findCanal)
        );
    }

    @Bean
    public RouterFunction<ServerResponse> transaccionRoutes(TransaccionHandler transaccionHandler) {
        return RouterFunctions.nest(RequestPredicates.path("/pago"),
                RouterFunctions
                        .route(POST("").and(contentType(APPLICATION_JSON)), transaccionHandler::save)
        );
    }

    @Bean
    public RouterFunction<ServerResponse> favoritoRoutes(FavoritoHandler favoritoHandler) {
        return RouterFunctions.nest(RequestPredicates.path("/favorito"),
                RouterFunctions
                        .route(POST("").and(contentType(APPLICATION_JSON)), favoritoHandler::save)
        );
    }


}
