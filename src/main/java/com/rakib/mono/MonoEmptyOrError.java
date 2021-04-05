package com.rakib.mono;

import com.rakib.util.SubscriberUtil;
import reactor.core.publisher.Mono;

import static com.rakib.util.SubscriberUtil.FAKER;

public class MonoEmptyOrError {
    public static void main(String[] args) {

        userRepository(1).subscribe(SubscriberUtil.getSubscriber());
        userRepository(2).subscribe(SubscriberUtil.getSubscriber());
        userRepository(3).subscribe(SubscriberUtil.getSubscriber());
    }

    private static Mono<String> userRepository(int userID) {
        if (userID == 1) {
            return Mono.just(FAKER.name().fullName());
        } else if (userID == 2) {
            return Mono.empty();
        } else {
            return Mono.error(() -> new Exception("Not Found"));
        }
    }
}
