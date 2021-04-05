package com.rakib.mono;

import com.rakib.util.SubscriberUtil;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

import java.util.Locale;
import java.util.function.Supplier;

import static com.rakib.util.SubscriberUtil.FAKER;

@Slf4j
public class MonoFromSupplier {

    public static void main(String[] args) {

        Mono<String> mono = Mono.fromSupplier(() -> getName());
        mono.subscribe(SubscriberUtil.getSubscriber());
        log.info("-----------------------------------");

        Supplier<String> stringSupplier = () -> getName();
        Mono.fromSupplier(stringSupplier).subscribe(SubscriberUtil.getSubscriber());


        log.info("-----------------------------------");
        Mono.fromSupplier(() -> getName())
                .subscribe(s -> System.out.println(s.toUpperCase(Locale.ROOT)));
    }
    private static String getName() {
        return FAKER.name().fullName();
    }
}
