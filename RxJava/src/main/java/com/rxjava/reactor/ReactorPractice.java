package com.rxjava.reactor;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ReactorPractice {

    public static void main(String[] args) {
        final List<String> fruitsBasket = Arrays.asList(new String []{"Apple", "Melon", "Kiwi", "Lemon"});
        final List<String> fruitsBasket2 = Arrays.asList(new String []{"Banana", "Water Melon", "Grape","Apple"});
        final List<String> fruitsBasket3 = Arrays.asList(new String []{"Lemon", "Strawberry", "Orange", "Kiwi", "Banana"});

        final List<List<String>> baskets = Arrays.asList(fruitsBasket, fruitsBasket2, fruitsBasket3);

        final Flux<List<String>> basketFlux = Flux.fromIterable(baskets);

        basketFlux.concatMap(basket -> {
            final Mono<List<String>> basketDistinctList = Flux.fromIterable(basket).distinct().collectList();
            final Mono<Map<String, Long>> countFruitsMono = Flux.fromIterable(basket)
                    .groupBy(fruits -> fruits)
                    .concatMap(groupedFlux -> groupedFlux.count()
                            .map(count -> {
                                final Map<String, Long> m = new LinkedHashMap<>();
                                m.put(groupedFlux.key(), count);

                                return m;
                            }))
                    .reduce((accumulatedMap, currentMap) -> new LinkedHashMap<String, Long>() {
                        {
                            putAll(accumulatedMap);
                            putAll(currentMap);
                        }
                    });
        });
    }
}
