package com.rakib.combina_publisher;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class ConcatWithPublisher {
    public static void main(String[] args) {
        Flux<Integer> just1 = Flux.just(1, 2, 3, 4);
        Flux<Integer> just2 = Flux.just(1, 2, 3, 4, 3, 5, 17);

        Flux<Integer> integerFlux = just1.concatWith(just2);
        integerFlux.subscribe(integer -> System.out.println("First: "+integer));

        Flux<Integer> integerFluxNext = Flux.concat(just1, just2);
        integerFluxNext.subscribe(integer -> System.out.println("Second: "+integer));
    }
}
