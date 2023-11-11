package org.example;

import java.io.*;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        ToyMarket market = new ToyMarket();

        market.addToy(ToyFactory.create("Cat", 10));
        market.addToy(ToyFactory.create("Mouse", 5));
        market.addToy(ToyFactory.create("Dog", 15));
        market.addToy(ToyFactory.create("Ball", 10, 50));
        market.addToy(ToyFactory.create("Bicycle", 5, 10));

        try (FileOutputStream outputStream = new FileOutputStream(new File("prize"));
             PrintWriter writer = new PrintWriter(new OutputStreamWriter(outputStream))) {
            try {
                for (int i = 0; i < 10; i++) {
                    Toy toy = market.getToy();
                    writer.println(String.format("%s %s", toy.getToyId(), toy.getToyName()));
                }
            } catch (IndexOutOfBoundsException e) {
                System.exit(0);
            } finally {
                outputStream.flush();
            }
        } catch (IOException e) {
            System.exit(1);
        }

        System.exit(0);
    }
}