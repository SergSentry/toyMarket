package org.example;

import java.util.*;
import java.util.stream.IntStream;

public class ToyMarket {
    private static final Random rnd = new Random();
    private final Map<UUID, Toy> toys = new HashMap<>();
    public void addToy(Toy toy) {
        if (toy == null)
            throw new IllegalArgumentException("Market can't add broken toy");

        if (!toys.containsKey(toy.getToyId())) {
            toys.put(toy.getToyId(), toy);
        } else {
           toys.get(toy.getToyId())
                   .addAmount(toy.getAmount())
                   .addFrequency(toy.getFrequency());
        }
    }

    public void removeToy(Toy toy) {
        if (toys.containsKey(toy.getToyId())) {
            toys.remove(toy.getToyId(), toy);
        }
    }

    public Toy getToy() throws IndexOutOfBoundsException  {
        int sumFreq = toys.values().stream().flatMapToInt(toy -> IntStream.of(toy.getFrequency())).sum();
        int freq = rnd.nextInt(sumFreq);
        int tmpSumFreq = 0;

        for (Toy toy: toys.values()) {
            tmpSumFreq += toy.getFrequency();
            if (freq < tmpSumFreq) {
                if (toy.getAmount() > 0) {
                    toy.subAmount(1);
                    return toy;
                }
            }
        }

        throw new IndexOutOfBoundsException("No toys in market");
    }
}
