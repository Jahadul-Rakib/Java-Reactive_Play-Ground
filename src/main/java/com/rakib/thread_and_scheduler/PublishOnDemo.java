package com.rakib.thread_and_scheduler;

import com.rakib.util.ThreadSleep;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

@Slf4j
public class PublishOnDemo {


    public static void main(String[] args) {
        Flux<Object> flux = Flux.create(fluxSink -> {
            getCurrentThread("Create");
            for (int i = 0; i < 10; i++) {
                fluxSink.next(i);
            }
        }).doOnNext(o -> getCurrentThread("Next: " + o));

        flux
                .publishOn(Schedulers.boundedElastic())
                .doOnNext(o -> getCurrentThread("Next: " + o))
                .publishOn(Schedulers.parallel())
                .subscribe(o -> getCurrentThread("Subscribe: "+ o));
        ThreadSleep.sleep(5);
    }

    private static void getCurrentThread(String msg) {
        log.info(msg + "\t\t: Thread: " + Thread.currentThread().getName());
    }
}
