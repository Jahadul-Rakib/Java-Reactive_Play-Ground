package com.rakib.sink;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

public class TryEmitValue {
    public static void main(String[] args) {
        Sinks.One<Object> one = Sinks.one();
        Mono<Object> mono = one.asMono();
        mono.subscribe(System.out::println);
        one.tryEmitValue("Hello");

        System.out.println("----------------------------");

        Sinks.Many<Object> many = Sinks.many().unicast().onBackpressureBuffer();
        Flux<Object> flux = many.asFlux();
        flux.subscribe(o -> System.out.println(o.toString()));
        many.tryEmitNext("R1");
        many.tryEmitNext("R2");
        many.tryEmitNext("R3");
        many.tryEmitNext("R4");

        System.out.println("----------------------------");

        Sinks.Many<Object> manyMulticas = Sinks.many().multicast().onBackpressureBuffer();
        Flux<Object> flux1 = manyMulticas.asFlux();
        flux1.subscribe(o -> System.out.println(o.toString()));
        manyMulticas.tryEmitNext("R1");
        manyMulticas.tryEmitNext("R2");
        manyMulticas.tryEmitNext("R3");
        manyMulticas.tryEmitNext("R4");

    }
}
