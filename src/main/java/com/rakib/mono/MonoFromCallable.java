package com.rakib.mono;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

import java.util.Locale;
import java.util.concurrent.Callable;

import static com.rakib.util.SubscriberUtil.FAKER;

@Slf4j
public class MonoFromCallable {

    public static void main(String[] args) {
        Callable<String> stringCallable = () -> getName();
        Mono.fromCallable(stringCallable)
                .subscribe(s -> System.out.println(s.toUpperCase(Locale.ROOT)));
    }
    private static String getName() {
        return FAKER.name().fullName();
    }
}
