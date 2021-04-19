package com.rakib.buffer;

import com.rakib.util.ThreadSleep;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Slf4j
public class Buffer {
    public static void main(String[] args) {
        eventStream()
                .buffer(5)   //take 5 data and then go further process
                .subscribe(System.out::println);

        eventStream()
                .bufferTimeout(5, Duration.ofSeconds(2))   //take 5 data and then go further process
                .subscribe(System.out::println);

        ThreadSleep.sleep(30);

    }

    private static Flux<String> eventStream(){
        return Flux.interval(Duration.ofMillis(10))
                .map(aLong -> "event"+aLong);
    }
}
