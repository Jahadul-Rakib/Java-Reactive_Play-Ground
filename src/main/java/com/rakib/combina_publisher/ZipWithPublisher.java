package com.rakib.combina_publisher;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class ZipWithPublisher {
    public static void main(String[] args) {
        Flux<Integer> just1 = Flux.just(1, 2, 3, 4);
        Flux<Integer> just2 = Flux.just(1, 2, 3, 4, 3, 5, 17);
        Flux<Integer> just3 = Flux.just(33, 22, 44, 55, 66);

        Flux
                .zip(just3, just1, just2)
                .subscribe(value -> System.out.println(value.toString()));

    }
}
