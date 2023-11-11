package org.example;

import java.util.UUID;

public class ToyImpl implements Toy {
    private final UUID toyId;
    private int frequency;
    private int amount;
    private final String toyName;

    public ToyImpl(UUID toyId, String toyName, int amount, int frequency) {
        this.toyId = toyId;
        this.frequency = Math.min(100, Math.max(0, frequency));
        this.toyName = toyName == null || toyName.isEmpty() ? "NoName" : toyName;
        this.amount = Math.max(0, amount);
    }

    @Override
    public UUID getToyId() {
        return this.toyId;
    }

    @Override
    public int getAmount() {
        return this.amount;
    }

    @Override
    public void setAmount(int amount) {
        this.amount = Math.max(0, amount);
    }

    @Override
    public Toy addAmount(int amount) {
        this.amount += Math.max(0, amount);
        return this;
    }

    @Override
    public Toy subAmount(int amount) {
        this.amount = Math.max(0, this.amount - amount);
        return this;
    }

    @Override
    public String getToyName() {
        return this.toyName;
    }

    @Override
    public int getFrequency() {
        return this.frequency;
    }

    @Override
    public void setFrequency(int frequency) {
        this.frequency = Math.min(100, Math.max(0, frequency));
    }

    @Override
    public Toy addFrequency(int frequency) {
        this.frequency = Math.min(100, Math.max(0, this.frequency + frequency));
        return this;
    }
}
