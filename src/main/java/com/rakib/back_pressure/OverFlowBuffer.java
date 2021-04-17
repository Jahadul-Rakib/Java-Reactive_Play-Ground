package com.rakib.back_pressure;

import com.rakib.util.ThreadSleep;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class OverFlowBuffer {
    public static void main(String[] args) {
        List<Object> queue = new ArrayList<>();

        Flux.create(fluxSink -> {
            for (int i = 1; i <= 100; i++) {
                fluxSink.next(i);
                System.out.println("Pushed: "+i);
            }
            fluxSink.complete();
        })
                .onBackpressureBuffer()
                .publishOn(Schedulers.boundedElastic())
                .doOnNext(queue::add)
                .subscribe(o -> System.out.println(o.toString()));

        queue.forEach(o -> System.out.println("Data: "+o.toString()));

        ThreadSleep.sleep(10);
    }
}
