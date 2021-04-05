package com.rakib.oparators;

import com.rakib.util.SubscriberUtil;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class DefaultEmpty {
    public static void main(String[] args) {
        getOrderNumber()
                .filter(integer -> integer > 10)
                .defaultIfEmpty(-100) //its run when do not exist any value
                .subscribe(SubscriberUtil.getSubscriber());
    }

    private static Flux<Integer> getOrderNumber(){
        return Flux.range(1,10);
    }
}
