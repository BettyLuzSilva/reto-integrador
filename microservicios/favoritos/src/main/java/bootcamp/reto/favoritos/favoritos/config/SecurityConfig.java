package bootcamp.reto.favoritos.favoritos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {
    @Bean
    SecurityWebFilterChain springWebFilterChain(ServerHttpSecurity http) {
        http.authorizeExchange()
                .anyExchange().authenticated()
                .and()
                .oauth2ResourceServer()
                .jwt();

//      En este bloque se permite  la consulta sin token para la consulta pero no para grabar
//        http.
//                authorizeExchange()
//                .pathMatchers("/favoritos/**").permitAll()
//                .pathMatchers(HttpMethod.OPTIONS).permitAll()
//                .anyExchange()
//                .authenticated()
//                .and()
//                .oauth2ResourceServer()
//                .jwt();


        return http.build();
   }
}
