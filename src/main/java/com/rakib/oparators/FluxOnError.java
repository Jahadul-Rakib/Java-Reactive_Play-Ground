package com.rakib.oparators;

import com.rakib.util.SubscriberUtil;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class FluxOnError {
    public static void main(String[] args) {
        Flux.range(1, 10)
                .log() //for logging
                .map(integer -> 10/(5-integer))
                .onErrorReturn(-1)//it will skip error from error throwing
                .subscribe(SubscriberUtil.getSubscriber());
    }
}
