package com.rakib.flux;

import com.rakib.util.SubscriberUtil;
import reactor.core.publisher.Flux;

public class FluxJust {
    public static void main(String[] args) {

        Flux<Object> flux = Flux.just("AnyThing", 1+" is Number", "Name is Rakib");
        flux.subscribe(SubscriberUtil.getSubscriber());

    }
}
