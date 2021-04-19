package com.rakib.back_pressure;

import com.rakib.util.ThreadSleep;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

@Slf4j
public class OverFlowBuffer {
    public static void main(String[] args) {
        Flux.create(fluxSink -> {
            for (int i = 1; i <= 100; i++) {
                fluxSink.next(i);
                System.out.println("Pushed: " + i);
            }
            fluxSink.complete();
        })
                .onBackpressureBuffer(50, v -> System.out.println("Dropped: " + v))
                .publishOn(Schedulers.boundedElastic())
                .subscribe(o -> System.out.println(o.toString()));
        ThreadSleep.sleep(10);
    }
}
