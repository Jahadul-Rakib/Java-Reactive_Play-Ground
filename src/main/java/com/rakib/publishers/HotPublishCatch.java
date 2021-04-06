package com.rakib.publishers;

import com.rakib.util.SubscriberUtil;
import com.rakib.util.ThreadSleep;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

@Slf4j
public class HotPublishCatch {

    public static void main(String[] args) {
        Flux<String> movieStream = Flux.fromStream(HotPublishCatch::getMovies)
                .delayElements(Duration.ofSeconds(1))
                .cache(); //its provide data from start and store on catch

        movieStream
                .subscribe(SubscriberUtil.getSubscriber("Hot"));
        ThreadSleep.sleep( 3);

        movieStream
                .subscribe(SubscriberUtil.getSubscriber("Hot 1"));
        ThreadSleep.sleep(30);
    }

    private static Stream<String> getMovies() {
        return Stream.of("AAA", "BBB", "CCC", "DDD", "EEE", "FFF");
    }
}
