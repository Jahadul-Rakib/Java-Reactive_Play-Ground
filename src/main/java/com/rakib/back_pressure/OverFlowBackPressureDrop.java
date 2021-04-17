package com.rakib.back_pressure;

import com.rakib.util.ThreadSleep;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.PriorityQueue;
import java.util.Queue;

@Slf4j
public class OverFlowBackPressureDrop {
    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue<>();

        Flux.create(fluxSink -> {
            for (int i = 1; i <= 100; i++) {
                fluxSink.next(i);
                System.out.println("Pushed: "+i);
            }
            fluxSink.complete();
        })
                .onBackpressureDrop(o -> queue.add((Integer) o))
                .publishOn(Schedulers.boundedElastic())
                //.doOnNext(o -> ThreadSleep.sleep(1))
                .subscribe(o -> System.out.println(o.toString()));

        ThreadSleep.sleep(10);
    }
}
