package com.rakib.util;

import com.github.javafaker.Faker;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class SubscriberUtil implements Subscriber<Object> {

    private String name;

    public SubscriberUtil() {
    }

    public SubscriberUtil(String name) {
        this.name = name+" - ";
    }

    public static final Faker FAKER =  Faker.instance();

    @Override
    public void onSubscribe(Subscription s) {
        s.request(Long.MAX_VALUE);
    }

    @Override
    public void onNext(Object o) {
        System.out.println(name+" "+"Data: "+o);
    }

    @Override
    public void onError(Throwable t) {
        System.out.println(name+" "+"Error: "+t.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.println(name+" "+"Completed !!!");
    }

    public static Subscriber<Object> getSubscriber(){
        return new SubscriberUtil();
    }
    public static Subscriber<Object> getSubscriber(String name){
        return new SubscriberUtil(name);
    }
}
