package com.rakib.thread_and_scheduler;

import com.rakib.util.ThreadSleep;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class PerallalDemo {


    public static void main(String[] args) {

        Flux.range(1,10)
                .parallel()
                .runOn(Schedulers.parallel())
                .doOnNext(integer -> getCurrentThread("next: "+ integer))
                .subscribe(integer -> getCurrentThread("SUb"+integer));
        ThreadSleep.sleep(5);


        System.out.println("----------------------------------------");


        List<Integer> list = new ArrayList<>();
        Flux.range(1,10)
                .parallel()
                .runOn(Schedulers.parallel())
                .sequential()
                .subscribe(value -> list.add(value));
        System.out.println("List Size: "+list.size());

        ThreadSleep.sleep(5);

    }
    private static void getCurrentThread(String msg) {
        log.info(msg + "\t\t: Thread: " + Thread.currentThread().getName());
    }
}
