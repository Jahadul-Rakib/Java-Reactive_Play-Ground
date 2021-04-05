package com.rakib.flux;

import com.rakib.util.SubscriberUtil;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class FluxToMono {

    public static void main(String[] args) {

        Flux.range(1, 10)
                .filter(integer -> integer > 9)
                .next()
                .subscribe(SubscriberUtil.getSubscriber());
    }
}
