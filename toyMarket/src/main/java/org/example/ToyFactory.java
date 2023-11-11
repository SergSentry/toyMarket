package org.example;

import java.util.Random;
import java.util.UUID;

public class ToyFactory {
    private static final Random rnd = new Random();

    public static Toy create(String name, int amount) {
        String toyName = name == null || name.isEmpty() ? "NoName" : name;
        return new ToyImpl(UUID.randomUUID(), toyName, Math.max(0, amount), rnd.nextInt(101));
    }

    public static Toy create(String name, int amount, int frequency) {
        String toyName = name == null || name.isEmpty() ? "NoName" : name;
        return new ToyImpl(UUID.randomUUID(), toyName, Math.max(0, amount), Math.min(100, Math.max(0, frequency)));
    }
}
