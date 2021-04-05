package com.rakib.flux;

import com.rakib.util.SubscriberUtil;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class FluxWithRange {

    public static void main(String[] args) {
        //its work like for loop
        List<Integer> integerList = Arrays.asList(123, 22, 34, 4, 50, 68, 77, 81);
        Flux.range(0, integerList.size())
                .map(integer -> integerList.get(integer))
                .map(integer -> integer+" Number")
                .subscribe(SubscriberUtil.getSubscriber());
    }
}
