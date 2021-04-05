package com.rakib.flux;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Slf4j
public class FluxFromCollections {


    public static void main(String[] args) {

        //List
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        Flux.fromIterable(integerList)
                .subscribe(integer -> log.info("From List: " + integer.toString()));

        //Array
        Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8};
        Flux.fromArray(array)
                .subscribe(integer -> log.info("From Array: " + integer.toString()));

        //Stream
        Stream<Integer> stream = integerList.stream();
        Flux.fromStream(stream)
                .subscribe(integer -> log.info("From Stream 1: " + integer.toString()));

        //for multiple time call same stream we should create stream again
        Flux.fromStream(() -> integerList.stream())
                .subscribe(integer -> log.info("From Stream 2: " + integer.toString()));

    }
}
