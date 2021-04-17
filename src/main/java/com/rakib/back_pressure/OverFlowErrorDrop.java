package com.rakib.back_pressure;

import com.rakib.util.ThreadSleep;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.List;
import java.util.Vector;

@Slf4j
public class OverFlowErrorDrop {
    public static void main(String[] args) {
        List<Integer> queue = new Vector<>();

        Flux.create(fluxSink -> {
            for (int i = 1; i <= 100; i++) {
                fluxSink.next(i);
                System.out.println("Pushed: "+i);
            }
            fluxSink.complete();
        })
                .onBackpressureError()
                .publishOn(Schedulers.boundedElastic())
                //.doOnNext(o -> ThreadSleep.sleep(1))
                .subscribe(o -> System.out.println(o.toString()));

        ThreadSleep.sleep(10);
    }
}
