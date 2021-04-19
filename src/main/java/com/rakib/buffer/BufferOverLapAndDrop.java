package com.rakib.buffer;

import com.rakib.util.ThreadSleep;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Slf4j
public class BufferOverLapAndDrop {
    public static void main(String[] args) {
        eventStream()
                .buffer(5, 2)   //it will take last 5 items and remove 2 item
                .subscribe(System.out::println);

        ThreadSleep.sleep(30);

    }

    private static Flux<String> eventStream(){
        return Flux.interval(Duration.ofMillis(100))
                .map(aLong -> "event"+aLong);
    }
}
