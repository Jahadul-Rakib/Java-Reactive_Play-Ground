package com.rakib.thread_and_scheduler;

import com.rakib.util.ThreadSleep;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

@Slf4j
public class SubscribeOnDemo {
    public static void main(String[] args) {
        Flux<Object> flux = Flux.create(fluxSink -> {
            getCurrentThread("Create");
            fluxSink.next(1);
        }).doOnNext(o -> getCurrentThread("Next: " + o));


        flux
                .doFirst(() -> getCurrentThread("First 2"))
                .subscribeOn(Schedulers.boundedElastic())
                .doFirst(() -> getCurrentThread("First 1"))
                .subscribe(o -> getCurrentThread("Subscribe: "+ o));
        ThreadSleep.sleep(5);
    }

    private static void getCurrentThread(String msg) {
        log.info(msg + "\t\t: Thread: " + Thread.currentThread().getName());
    }
}
