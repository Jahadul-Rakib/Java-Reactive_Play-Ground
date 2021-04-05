package com.rakib.oparators;

import com.rakib.util.SubscriberUtil;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class HandleOperator {
    public static void main(String[] args) {
        //handle = filter + map
        Flux.range(1, 10)
                .handle((integer, synchronousSink) -> {
                    if (integer % 2 == 0) {
                        synchronousSink.next(integer);
                    }else if (integer == 7){
                        synchronousSink.complete();
                    }else {
                        synchronousSink.next(integer+" :Odd Number");
                    }
                }).subscribe(SubscriberUtil.getSubscriber());
    }
}
