package com.rakib.util;

import com.github.javafaker.Faker;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class SubscriberUtil implements Subscriber<Object> {

    public static final Faker FAKER =  Faker.instance();

    @Override
    public void onSubscribe(Subscription s) {
        s.request(Long.MAX_VALUE);
    }

    @Override
    public void onNext(Object o) {
        System.out.println(o);
    }

    @Override
    public void onError(Throwable t) {
        System.out.println("Error: "+t.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.println("Completed !!!");
    }

    public static Subscriber<Object> getSubscriber(){
        return new SubscriberUtil();
    }
}
