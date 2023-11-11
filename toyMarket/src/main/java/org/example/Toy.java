package org.example;

import java.util.UUID;

public interface Toy {
    UUID getToyId();

    String getToyName();

    int getAmount();

    void setAmount(int amount);

    Toy addAmount(int amount);

    Toy subAmount(int amount);

    int getFrequency();

    void setFrequency(int frequency);

    Toy addFrequency(int frequency);
}
