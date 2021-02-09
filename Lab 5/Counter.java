package com.example.lab5_1;

public class Counter {
    private int value;
    private int stepValue;
    private int minimumValue;
    private int maximumValue;

    public Counter() {
        this.minimumValue = -100;
        this.maximumValue = 100;
        this.stepValue = 1;
        this.value = 0;
    }

    public Counter(int minimumValue, int maximumValue, int startingValue, int stepValue) {
        this.minimumValue = minimumValue;
        this.maximumValue = maximumValue;
        this.stepValue = stepValue;
        this.value = startingValue;
    }

    public void add() {
        if (this.value + this.stepValue <= this.maximumValue) {
            this.value += this.stepValue;
        }
    }

    public void subtract() {
        if (this.value - this.stepValue >= this.minimumValue) {
            this.value -= this.stepValue;
        }
    }

    public void reset() {
        this.value = 0;
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return Integer.toString(this.value);
    }

    public String toBinaryString() {
        return Integer.toBinaryString(this.value);
    }

    public String toHexString() {
        return Integer.toHexString(this.value);
    }
}
