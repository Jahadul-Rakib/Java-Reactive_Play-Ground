package com.rakib.oparators;

import com.rakib.util.AppConstant;
import com.rakib.util.SubscriberUtil;
import com.rakib.util.ThreadSleep;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Slf4j
public class FluxOnError {
    public static void main(String[] args) {
        Flux.range(1, 10)
                .log() //for logging
                .map(integer -> 10/(5-integer))
                .onErrorReturn(-1)//it will skip error from error throwing
                .subscribe(SubscriberUtil.getSubscriber());
        log.warn("----------------------------------------");
        Flux.range(1, 10)
                .log() //for logging
                .map(integer -> 10/(5-integer))
                .onErrorResume(throwable -> fallBack())//it will continue process after error occure without any effect
                .subscribe(SubscriberUtil.getSubscriber());
        log.warn("----------------------------------------");
        Flux.range(1, 10)
                .log() //for logging
                .map(integer -> 10/(5-integer))
                .onErrorContinue((throwable, o) -> {  //it will continue process after error occure without any effect

                }).subscribe(SubscriberUtil.getSubscriber());


        log.warn("----------------------------------------");
        getOrderNumber()
                .timeout(Duration.ofSeconds(2), fallBack()) //if do not get any response within 2 seconds, then it will call fallback method
                .subscribe(SubscriberUtil.getSubscriber());


        ThreadSleep.sleep(60);
    }

    private static Mono<Integer> fallBack(){
        return Mono.fromSupplier(() -> AppConstant.FAKER.random().nextInt(100, 500));
    }

    private static Flux<Integer> getOrderNumber(){
        return Flux.range(1,10).delayElements(Duration.ofSeconds(1));
    }
}
