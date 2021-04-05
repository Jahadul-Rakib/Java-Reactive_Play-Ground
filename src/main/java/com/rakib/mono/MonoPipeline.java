package com.rakib.mono;

import com.rakib.util.SubscriberUtil;
import com.rakib.util.ThreadSleep;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.Locale;

import static com.rakib.util.SubscriberUtil.FAKER;

@Slf4j
public class MonoPipeline {

    public static void main(String[] args) {
        getName().subscribe(SubscriberUtil.getSubscriber());
        getName().subscribeOn(Schedulers.boundedElastic()).subscribe(SubscriberUtil.getSubscriber());
        getName().subscribeOn(Schedulers.boundedElastic()).subscribe(SubscriberUtil.getSubscriber());

        ThreadSleep.sleep(10);
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
