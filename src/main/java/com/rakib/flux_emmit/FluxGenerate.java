package com.rakib.flux_emmit;

import com.rakib.util.SubscriberUtil;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import static com.rakib.util.SubscriberUtil.FAKER;

@Slf4j
public class FluxGenerate {
    public static void main(String[] args) {
        Flux.generate(synchronousSink -> {
            synchronousSink.next(FAKER.country().name());
        })
                .take(5) //unless it will go infinte loop
                .subscribe(SubscriberUtil.getSubscriber());
    }
}
