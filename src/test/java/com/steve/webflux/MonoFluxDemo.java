package com.steve.webflux;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoFluxDemo {
@Test
    public void monoDemo(){

       Mono<Object> singleResponse = Mono.just("Hey here it is Iam a reactive response")
               .then(Mono.error(new RuntimeException("something is wrong")))
               .log();

        singleResponse.subscribe(System.out::println);
    }
    @Test
    public void fluxDemo(){

        Flux<String> pluralResponse = Flux.just("iPhone+10GB","iPad+100GB","Android+10GB","Android+100GB")
                .concatWithValues("Samsung+500GB")
                .log();

        pluralResponse.subscribe(System.out::println);
    }
}
