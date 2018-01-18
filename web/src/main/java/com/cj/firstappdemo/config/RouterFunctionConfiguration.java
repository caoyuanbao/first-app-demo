package com.cj.firstappdemo.config;

import com.cj.firstappdemo.domain.User;
import com.cj.firstappdemo.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collection;

/**
 * Created by Administrator on 2018/1/18 0018.
 */
@Configuration
public class RouterFunctionConfiguration {

    @Bean
    public RouterFunction<ServerResponse> personFindAll(UserRepository userRepository){
        Collection<User> users = userRepository.findAll();
        return RouterFunctions.route(RequestPredicates.POST("/person/find/all"),
                request -> {
                    Mono<ServerResponse> response = null;
                    Flux<User> userFlux = Flux.fromIterable(users);
                    return ServerResponse.ok().body(userFlux,User.class);
                });
    }
}
