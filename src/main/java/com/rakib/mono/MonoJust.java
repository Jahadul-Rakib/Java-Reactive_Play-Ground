package com.rakib.mono;

import com.rakib.util.SubscriberUtil;
import reactor.core.publisher.Mono;

public class MonoJust {

    public static void main(String[] args) {
        Mono<String> data = Mono.just("Data");
        Mono<String> data1 = Mono.just("Data").map(String::toUpperCase);
        data.subscribe(SubscriberUtil.getSubscriber());
        data1.subscribe(SubscriberUtil.getSubscriber());
    }
}
