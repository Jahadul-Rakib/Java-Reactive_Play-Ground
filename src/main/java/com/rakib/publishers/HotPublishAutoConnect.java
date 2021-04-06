package com.rakib.publishers;

import com.rakib.util.SubscriberUtil;
import com.rakib.util.ThreadSleep;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

@Slf4j
public class HotPublishAutoConnect {

    public static void main(String[] args) {
        Flux<String> movieStream = Flux.fromStream(HotPublishAutoConnect::getMovies)
                .delayElements(Duration.ofSeconds(1))
                .publish()
                .autoConnect(1);

        movieStream
                .subscribe(SubscriberUtil.getSubscriber("Hot"));
        ThreadSleep.sleep(2);

        movieStream
                .subscribe(SubscriberUtil.getSubscriber("Hot 1"));
        ThreadSleep.sleep(30);
    }

    private static Stream<String> getMovies() {
        return Stream.of("AAA", "DDD", "CCC", "BBB", "EEE", "FFF");
    }
}
