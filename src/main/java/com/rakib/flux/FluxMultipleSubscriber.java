package com.rakib.flux;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class FluxMultipleSubscriber {
    public static void main(String[] args) {

        Flux<Object> flux = Flux.just("AnyThing", 1+" is Number", "Name is Rakib");
        flux.subscribe(value-> log.info("Sub 1: "+value.toString()));
        flux.subscribe(value-> log.info("Sub 2: "+value.toString()));

    }
}
