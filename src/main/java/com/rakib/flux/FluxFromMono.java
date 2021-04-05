package com.rakib.flux;

import com.rakib.util.SubscriberUtil;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
public class FluxFromMono {

    public static void main(String[] args) {
        Mono<String> mono = Mono.just("A");
        Flux<String> flux = Flux.from(mono);
        flux.subscribe(SubscriberUtil.getSubscriber());
    }
}
