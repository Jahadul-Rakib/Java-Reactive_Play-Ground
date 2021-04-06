package com.rakib.thread_and_scheduler;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class ThreadDemo {
    public static void main(String[] args) {
        Flux<Object> flux = Flux.create(fluxSink -> {
            getCurrentThread("Create");
            fluxSink.next(1);
        }).doOnNext(o -> getCurrentThread("Next: " + o));
        flux.subscribe(o -> getCurrentThread("Subscribe: "+ o));
    }

    private static void getCurrentThread(String msg) {
        log.info(msg + "\t\t: Thread: " + Thread.currentThread().getName());
    }
}
