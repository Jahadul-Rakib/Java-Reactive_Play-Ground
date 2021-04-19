package com.rakib.combina_publisher;

import com.rakib.util.ThreadSleep;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Slf4j
public class CombineLatestPublisher {
    public static void main(String[] args) {


        Flux
                .combineLatest(getString(), getInteger(), (s, i) -> s+i)
                .subscribe(System.out::println);

        ThreadSleep.sleep(10);
    }

    private static Flux<String> getString(){
        return Flux.just("A","B","C","D")
                .delayElements(Duration.ofSeconds(1));
    }
    private static Flux<Integer> getInteger(){
        return Flux.just(1,2,3,4,5,6)
                .delayElements(Duration.ofSeconds(2));
    }
}
