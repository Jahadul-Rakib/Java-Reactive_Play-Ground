package com.rakib.oparators;

import com.rakib.util.AppConstant;
import com.rakib.util.SubscriberUtil;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class FluxOperator {
    public static void main(String[] args) {
        Flux.create(fluxSink -> {
            for (int i = 0; i < 11; i++) {
                fluxSink.next(AppConstant.FAKER.country().name());
            }
            fluxSink.error(new Exception("Creation Error."));
            log.info("---------------------------Completed");
        })
                .doOnComplete(() -> log.info("doOnComplete"))
                .doFirst(() -> log.info("doFirst"))
                .doOnNext(o -> log.info("doOnNext: "+o))
                .doOnSubscribe(subscription -> log.info("doOnSubscribe: "+ subscription))
                .doOnRequest(value -> log.info("doOnRequest: "+ value))
                .doOnError(throwable -> log.info("doOnError: "+ throwable.getMessage()))
                .doOnTerminate(() -> log.info("doOnTerminate"))
                .doOnCancel(() -> log.info("doOnCancel"))
                .doFinally(signalType -> log.info("doFinally 1: "+ signalType))
                .doOnDiscard(Object.class, o -> log.info("doOnDiscard: "+ o))
                .take(3)
                .doFinally(signalType -> log.info("doFinally 2: "+ signalType))
                .subscribe(SubscriberUtil.getSubscriber());
    }
}
