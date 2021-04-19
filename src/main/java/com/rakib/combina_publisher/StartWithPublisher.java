package com.rakib.combina_publisher;

import com.rakib.util.AppConstant;
import com.rakib.util.SubscriberUtil;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class StartWithPublisher {
    public static void main(String[] args) {

        generateName()
                .take(5)
                .subscribe(SubscriberUtil.getSubscriber("First"));

        generateName()
                .take(5)
                .filter(s -> s.startsWith("A"))
                .subscribe(SubscriberUtil.getSubscriber("Second"));

    }

    public static Flux<String> generateName(){
        return Flux.generate(data -> {
            String name = AppConstant.FAKER.name().fullName();
            data.next(name);
        });
    }
    public static Flux<String> generateColor(){
        return Flux.generate(data -> {
            String name = AppConstant.FAKER.color().name();
            data.next(name);
        });
    }
}
