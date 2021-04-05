package com.rakib.oparators;

import com.rakib.util.SubscriberUtil;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class FluxLimitRate {
    public static void main(String[] args) {
        Flux.range(1, 1000)
                .limitRate(100) //how many items are process at a time
                .subscribe(SubscriberUtil.getSubscriber());
    }
}
