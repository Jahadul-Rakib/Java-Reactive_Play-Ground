package com.rakib.flux_emmit;

import com.rakib.util.SubscriberUtil;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class FluxPush {
    public static void main(String[] args) {
        Flux.push( fluxSink -> {
            fluxSink.next("Rakib");
            fluxSink.next("Rakib");
            fluxSink.next("Rakib");
        }).subscribe(SubscriberUtil.getSubscriber());
    }
}
