package com.rakib.mono;

import com.rakib.util.ThreadSleep;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.Locale;

import static com.rakib.util.SubscriberUtil.FAKER;

@Slf4j
public class MonoBlocking {

    public static void main(String[] args) {
        // it will block main thread.

        String name = getName()
                .subscribeOn(Schedulers.boundedElastic())
                .block();
        log.info(name);
        String name1 = getName()
                .subscribeOn(Schedulers.boundedElastic())
                .block();
        log.info(name1);
    }

    private static Mono<String> getName() {
        log.info("Entered into supplier");
        return Mono.fromSupplier(() -> {
            ThreadSleep.sleep(2);
            log.info("Entered into Pipeline");
            return FAKER.name().fullName();
        }).map(s -> s.toUpperCase(Locale.ROOT));
    }
}
