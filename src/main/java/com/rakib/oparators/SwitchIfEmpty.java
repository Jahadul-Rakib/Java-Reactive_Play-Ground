package com.rakib.oparators;

import com.rakib.util.SubscriberUtil;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class SwitchIfEmpty {
    public static void main(String[] args) {
        getOrderNumber()
                .filter(integer -> integer > 10)
                .switchIfEmpty(fallBack()) //its run when do not exist any value
                .subscribe(SubscriberUtil.getSubscriber());
    }
    private static Flux<Integer> fallBack(){
        return Flux.range(1,5);
    }
    private static Flux<Integer> getOrderNumber(){
        return Flux.range(1,10);
    }
}
