package com.rakib.flux_emmit;

import com.rakib.util.SubscriberUtil;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class FluxTake {
    public static void main(String[] args) {
        Flux.range(1,9)
                .take(4)
                .subscribe(SubscriberUtil.getSubscriber());
    }
}
