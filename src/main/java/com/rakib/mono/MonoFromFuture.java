package com.rakib.mono;

import com.rakib.util.SubscriberUtil;
import com.rakib.util.ThreadSleep;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

import static com.rakib.util.SubscriberUtil.FAKER;

@Slf4j
public class MonoFromFuture {

    public static void main(String[] args) {
        Mono.fromFuture(() -> getName()).subscribe(SubscriberUtil.getSubscriber());
        ThreadSleep.sleep(2);
    }

    private static CompletableFuture<String> getName() {
        return CompletableFuture.supplyAsync(FAKER.name()::fullName);
    }
}
