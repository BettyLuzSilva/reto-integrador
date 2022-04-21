package bootcamp.reto.pagoservicios.routes;

import bootcamp.reto.pagoservicios.handlers.ServicioHandler;
import bootcamp.reto.pagoservicios.handlers.TransaccionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class RouterConfiguration {
    @Bean
    public RouterFunction<ServerResponse> servicioRoutes(ServicioHandler servicioHandler){
        return RouterFunctions.nest(RequestPredicates.path("/servicios"),
                RouterFunctions.route(GET(""), servicioHandler::findAll)
                        .andRoute(GET("/canal/{canal}"),servicioHandler::findCanal)
                        .andRoute(POST("").and(accept(APPLICATION_JSON)),servicioHandler::save)
        );
    }

    @Bean
    public RouterFunction<ServerResponse> transaccionRoutes(TransaccionHandler transaccionHandler){
        return RouterFunctions.nest(RequestPredicates.path("/pagos"),
               RouterFunctions.route(GET(""), transaccionHandler::findAll)
                       .andRoute(POST("").and(accept(APPLICATION_JSON)),transaccionHandler::save)
        );
    }


}
