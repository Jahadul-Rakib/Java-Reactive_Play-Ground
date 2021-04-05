package com.rakib.flux_emmit;

import com.rakib.util.SubscriberUtil;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import static com.rakib.util.SubscriberUtil.FAKER;

@Slf4j
public class FluxCreate {
    public static void main(String[] args) {
        Flux.create(fluxSink -> {
            for (int i = 1; i <= 30; i++) {
                fluxSink.next(FAKER.country().name());
            }
            fluxSink.complete();
        }).subscribe(SubscriberUtil.getSubscriber());
    }
}
