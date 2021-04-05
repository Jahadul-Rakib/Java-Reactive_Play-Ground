package com.rakib.mono;

import com.rakib.util.SubscriberUtil;
import com.rakib.util.ThreadSleep;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
public class MonoFromRunnable {

    public static void main(String[] args) {
        Mono.fromRunnable(() -> getRunnable())
                .subscribe(SubscriberUtil.getSubscriber());

        //OR
        Mono.fromRunnable(() -> System.out.println("From Runnable inline"))
                .subscribe(SubscriberUtil.getSubscriber());

        //OR
        Runnable runnable = () -> System.out.println("From Runnable annonimus");
        Mono.fromRunnable(runnable)
                .subscribe(SubscriberUtil.getSubscriber());


        ThreadSleep.sleep(5);
    }

    private static void getRunnable() {
        ThreadSleep.sleep(1);
        log.info("Runnable Completed");
    }
}
