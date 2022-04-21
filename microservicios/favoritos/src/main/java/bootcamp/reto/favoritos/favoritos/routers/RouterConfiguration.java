package bootcamp.reto.favoritos.favoritos.routers;

import bootcamp.reto.favoritos.favoritos.handlers.FavoritoHandler;
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
    public RouterFunction<ServerResponse> favoritoRoutes(FavoritoHandler favoritoHandler){
        return RouterFunctions.nest(RequestPredicates.path("/favoritos"),
                RouterFunctions.route(GET(""), favoritoHandler::findAll)
                        .andRoute(POST("").and(accept(APPLICATION_JSON)),favoritoHandler::save)
        );
    }

}
