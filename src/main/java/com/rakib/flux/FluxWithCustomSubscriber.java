package com.rakib.flux;

import com.rakib.util.ThreadSleep;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicReference;

@Slf4j
public class FluxWithCustomSubscriber {
    public static void main(String[] args) {
        AtomicReference<Subscription> atomicReference = new AtomicReference<>();
        Flux.range(1,10)
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        atomicReference.set(s);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        log.info("Data: "+integer.toString());
                    }

                    @Override
                    public void onError(Throwable t) {
                        log.info("Error: "+t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        log.info("Completed Done.");
                    }
                });

        ThreadSleep.sleep(3);
        atomicReference.get().request(3);

        ThreadSleep.sleep(5);
        atomicReference.get().request(3);


        ThreadSleep.sleep(3);
        atomicReference.get().cancel();


        //its not work because after cancle() flux will not work
        ThreadSleep.sleep(2);
        atomicReference.get().request(1);

        ThreadSleep.sleep(3);
    }
}
