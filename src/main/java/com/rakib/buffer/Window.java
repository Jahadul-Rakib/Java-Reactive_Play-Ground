package com.rakib.buffer;

import com.rakib.util.ThreadSleep;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Slf4j
public class Window {
    public static void main(String[] args) {
        eventStream()
                .window(5)
                .subscribe(System.out::println);

        ThreadSleep.sleep(30);

    }

    private static Flux<String> eventStream(){
        return Flux.interval(Duration.ofMillis(100))
                .map(aLong -> "event"+aLong);
    }
}
