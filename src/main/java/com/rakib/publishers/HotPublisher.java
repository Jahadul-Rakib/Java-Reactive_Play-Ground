package com.rakib.publishers;

import com.rakib.util.SubscriberUtil;
import com.rakib.util.ThreadSleep;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

@Slf4j
public class HotPublisher {

    public static void main(String[] args) {
        Flux<String> movieStream = Flux.fromStream(HotPublisher::getMovies)
                .delayElements(Duration.ofSeconds(1))
                .share(); //convert cold to hot publisher
                          //its work mostly tv streaming...on same time people watch same thing
        movieStream
                .subscribe(SubscriberUtil.getSubscriber("Hot"));
        ThreadSleep.sleep(2);

        movieStream
                .subscribe(SubscriberUtil.getSubscriber("Hot 1"));
        ThreadSleep.sleep(2);

        //OR

        Flux<String> movieStream1 = Flux.fromStream(HotPublisher::getMovies)
                .delayElements(Duration.ofSeconds(1))
                .publish()
                .refCount(1);

        movieStream1
                .subscribe(SubscriberUtil.getSubscriber("Hot"));
        ThreadSleep.sleep(2);

        movieStream1
                .subscribe(SubscriberUtil.getSubscriber("Hot 1"));
        ThreadSleep.sleep(60);
    }

    private static Stream<String> getMovies() {
        return Stream.of("AAA", "DDD", "CCC", "BBB", "EEE", "FFF");
    }
}
