package com.rakib.flux;

import com.rakib.util.SubscriberUtil;
import com.rakib.util.ThreadSleep;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Slf4j
public class FluxWithIntervel {

    public static void main(String[] args) {
        //its do not block main thread
        Flux.interval(Duration.ofSeconds(1))
                .subscribe(SubscriberUtil.getSubscriber());

        ThreadSleep.sleep(10);
    }
}
