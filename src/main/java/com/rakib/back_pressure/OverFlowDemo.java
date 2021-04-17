package com.rakib.back_pressure;

import com.rakib.util.ThreadSleep;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

@Slf4j
public class OverFlowDemo {
    public static void main(String[] args) {
        Flux.create(fluxSink -> {
            for (int i = 1; i <= 500; i++) {
                fluxSink.next(i);
                System.out.println("Pushed: "+i);
            }
            fluxSink.complete();
        })
                .publishOn(Schedulers.boundedElastic())
                .doOnNext(o -> ThreadSleep.sleep(1))
                .subscribe(o -> System.out.println(o.toString()));

        ThreadSleep.sleep(60);
    }
}
